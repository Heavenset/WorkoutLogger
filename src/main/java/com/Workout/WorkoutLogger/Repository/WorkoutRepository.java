package com.Workout.WorkoutLogger.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Workout.WorkoutLogger.Model.Workout;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout, Long> {

}