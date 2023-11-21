package com.Workout.WorkoutLogger.Controller.Registration;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Workout.WorkoutLogger.Service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegestrationController {
	private final UserService userService;

	public String register(@RequestBody RegistrationRequest request) {
		return userService.register(request);

	}
}
