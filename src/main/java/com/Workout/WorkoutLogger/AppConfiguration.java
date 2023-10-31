package com.Workout.WorkoutLogger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Workout.WorkoutLogger.Service.WorkoutService;
import com.Workout.WorkoutLogger.Service.WorkoutServiceIMPL;

@Configuration
public class AppConfiguration {
	@Bean
	public WorkoutService workoutService() {
		return new WorkoutServiceIMPL(); // Replace with your implementation
	}

}
