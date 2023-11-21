package com.Workout.WorkoutLogger.Service;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Workout.WorkoutLogger.Controller.Registration.RegistrationRequest;
import com.Workout.WorkoutLogger.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public String register(RegistrationRequest request) {
// Perform validation on the request

// Create a new user entity
		User newUser = new User();
		newUser.setName(request.getUsername());
		newUser.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
		userRepository.save(newUser);

		return "User registered successfully!";
	}
}