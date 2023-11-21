package com.Workout.WorkoutLogger.Service;

import com.Workout.WorkoutLogger.Controller.Registration.RegistrationRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class RegistrationService {

	public String register(RegistrationRequest request) {
		return "works";
	}
}
