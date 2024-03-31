package com.Workout.WorkoutLogger.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Workout.WorkoutLogger.DTOs.JwtRequest;
import com.Workout.WorkoutLogger.DTOs.UserRegistrationDto;
import com.Workout.WorkoutLogger.Service.AuthenticationService;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        return authenticationService.createAuthToken(authRequest);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createNewUser(@RequestBody UserRegistrationDto registrationUserDto) {
        return authenticationService.createNewUser(registrationUserDto);
    }
}