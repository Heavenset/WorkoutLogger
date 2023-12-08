package com.Workout.WorkoutLogger.Repository;

import java.util.Optional;

import com.Workout.WorkoutLogger.Model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface UserRepository extends JpaRepository<UserModel, Integer> {
	@Transactional(readOnly = true)
	static Optional<UserModel> findByUsername(String username) {
		return null;
	}
}
