package com.Workout.WorkoutLogger.Service;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Workout.WorkoutLogger.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public void registerUser(String username, String password) {
		User user = new User();
		user.setName(username);
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
	}
}
