package com.Workout.WorkoutLogger.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Workout.WorkoutLogger.Model.Workout;
import com.Workout.WorkoutLogger.Repository.WorkoutRepository;


@Service

public class WorkoutServiceIMPL implements WorkoutService {

	@Autowired
	private WorkoutRepository workoutRepository;

	@Override
	public Workout saveWorkout(Workout workout) {
		return workoutRepository.save(workout);
	}
}
