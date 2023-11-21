package com.Workout.WorkoutLogger.Controller.Registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
	private final String userName;
	private final String password;
	private final String email;

	public String getUsername() {
		return userName;
	}

	public String register(RegistrationRequest request) {
		return "works";
	}

}
