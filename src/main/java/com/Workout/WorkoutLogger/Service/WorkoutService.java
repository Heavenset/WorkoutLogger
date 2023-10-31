package com.Workout.WorkoutLogger.Service;

import org.springframework.stereotype.Service;

import com.Workout.WorkoutLogger.Model.Workout;

@Service
public interface WorkoutService {
	public Workout saveWorkout(Workout workout);
}
