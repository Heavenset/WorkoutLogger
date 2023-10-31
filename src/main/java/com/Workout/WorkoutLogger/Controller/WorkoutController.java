package com.Workout.WorkoutLogger.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Workout.WorkoutLogger.Model.Workout;
import com.Workout.WorkoutLogger.Service.WorkoutService;

@Controller
public class WorkoutController {
	@Autowired
	private WorkoutService workoutService;

	@GetMapping(value="/add")
	public String addWorkout(Workout workout) {
		workoutService.saveWorkout(workout);
		return "New workout has been added";
	}

}
