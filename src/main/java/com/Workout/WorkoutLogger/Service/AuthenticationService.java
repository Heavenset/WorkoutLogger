package com.Workout.WorkoutLogger.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Workout.WorkoutLogger.DTOs.JwtRequest;
import com.Workout.WorkoutLogger.DTOs.JwtResponse;
import com.Workout.WorkoutLogger.DTOs.UserDTO;
import com.Workout.WorkoutLogger.DTOs.UserRegistrationDto;
import com.Workout.WorkoutLogger.Entity.User;
import com.Workout.WorkoutLogger.Error.AppError;
import com.Workout.WorkoutLogger.Util.JwtTokenUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	private final UserService userService;
	private final JwtTokenUtils jwtTokenUtils;
	private final AuthenticationManager authenticationManager;

	public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		}
		catch (BadCredentialsException e) {
			return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Неправильный логин или пароль"),
					HttpStatus.UNAUTHORIZED);
		}
		UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
		String token = jwtTokenUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	public ResponseEntity<?> createNewUser(@RequestBody UserRegistrationDto registrationUserDto) {
		if (!registrationUserDto.getPassword().equals(registrationUserDto.getConfirmPassword())) {
			return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пароли не совпадают"),
					HttpStatus.BAD_REQUEST);
		}
		if (userService.findByUserName(registrationUserDto.getUsername()).isPresent()) {
			return new ResponseEntity<>(
					new AppError(HttpStatus.BAD_REQUEST.value(), "Пользователь с указанным именем уже существует"),
					HttpStatus.BAD_REQUEST);
		}
		User user = userService.createNewUser(registrationUserDto);
		return ResponseEntity.ok(new UserDTO(user.getId(), user.getUsername(), user.getEmail()));
	}
}
