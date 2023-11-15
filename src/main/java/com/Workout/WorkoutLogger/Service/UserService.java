package com.Workout.WorkoutLogger.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Workout.WorkoutLogger.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class UserService implements UserDetailsService {

	private static final String USER_NOT_FOUND = "User is not found."
			+ "\nEmail: %s";
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		return UserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
	}

}
