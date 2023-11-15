package com.Workout.WorkoutLogger.Repository;

import java.util.Optional;

import com.Workout.WorkoutLogger.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface UserRepository extends JpaRepository<Object, Object> {
	@Transactional(readOnly = true)
	static Optional<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
