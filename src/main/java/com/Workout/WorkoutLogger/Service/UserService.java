package com.Workout.WorkoutLogger.Service;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.Workout.WorkoutLogger.Model.RegistrationRequestModel;
import com.Workout.WorkoutLogger.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class UserService {

	private final UserRepository userRepository;

	public String register(RegistrationRequestModel request) {
// Perform validation on the request

// Create a new user entity
		User newUser = new User();
		newUser.setName(request.getUsername());


		return "User registered successfully!";
	}
}