package com.Workout.WorkoutLogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.Workout.WorkoutLogger.Entity")
@ComponentScan(basePackages={"com.Workout.WorkoutLogger.Repository"})	
@EnableJpaRepositories("com.Workout.WorkoutLogger.*")
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

}
