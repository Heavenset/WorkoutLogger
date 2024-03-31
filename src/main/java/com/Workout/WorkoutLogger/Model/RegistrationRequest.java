package com.Workout.WorkoutLogger.Model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
	private final String username;
	private final String password;
	private final String email;

	public String getUsername() {
		return username;
	}

	public String register(RegistrationRequest request) {
		return "works";
	}

}
