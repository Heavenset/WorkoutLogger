package com.Workout.WorkoutLogger.DTOs;

import lombok.Data;

@Data
public class UserRegistrationDto {
	private String username;
	private String password;
	private String confirmPassword;
	private String email;
}
