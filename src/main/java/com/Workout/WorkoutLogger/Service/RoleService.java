package com.Workout.WorkoutLogger.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.Workout.WorkoutLogger.Entity.Role;
import com.Workout.WorkoutLogger.Repository.RoleRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
	private final RoleRepository roleRepository;

	public Role getUserRole() {
		return roleRepository.findByName("ROLE_USER").get();
	}
}
