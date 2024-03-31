package com.Workout.WorkoutLogger.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Workout.WorkoutLogger.Entity.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}
