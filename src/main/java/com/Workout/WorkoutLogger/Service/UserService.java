package com.Workout.WorkoutLogger.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Workout.WorkoutLogger.DTOs.UserRegistrationDto;
import com.Workout.WorkoutLogger.Entity.Role;
import com.Workout.WorkoutLogger.Entity.User;
import com.Workout.WorkoutLogger.Repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public Optional<User> findByUserName(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByUserName(username).orElseThrow(
				() -> new UsernameNotFoundException(String.format("Пользователь '%s' не найден", username)));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.name()))
						.collect(Collectors.toList()));
	}

	public User createNewUser(UserRegistrationDto registrationUserDto) {
		User user = new User();
		user.setUsername(registrationUserDto.getUsername());
		user.setEmail(registrationUserDto.getEmail());
		user.setPassword(passwordEncoder.encode(registrationUserDto.getPassword()));

	    // Initialize the roles set
	    user.setRoles(new HashSet<>());
	    
	    // Add roles to the user
	    user.getRoles().add(Role.USER);
	    // If you have other roles, you can add them like this:
	    // user.getRoles().add(Role.ROLE_ADMIN);
		return userRepository.save(user);
	}
}
