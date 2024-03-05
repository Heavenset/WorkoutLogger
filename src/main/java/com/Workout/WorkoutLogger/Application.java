package com.Workout.WorkoutLogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.Workout.WorkoutLogger.Repository")
@ComponentScan("com.Workout.WorkoutLogger.Util")
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

}
