package com.Workout.WorkoutLogger.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Workout.WorkoutLogger.Model.WorkoutModel;

@Repository
public interface WorkoutRepository extends JpaRepository<WorkoutModel, Long> {
}
