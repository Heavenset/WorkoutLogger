package com.Workout.WorkoutLogger.Service;

import com.Workout.WorkoutLogger.Model.RegistrationRequestModel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class RegistrationService {

	public String register(RegistrationRequestModel request) {
		return "works";
	}
}
