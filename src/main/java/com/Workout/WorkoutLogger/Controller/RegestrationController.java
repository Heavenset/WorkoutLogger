package com.Workout.WorkoutLogger.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegestrationController {

	@GetMapping(value = "/login")
	public String login() {
		return "login.html";
	}
}
