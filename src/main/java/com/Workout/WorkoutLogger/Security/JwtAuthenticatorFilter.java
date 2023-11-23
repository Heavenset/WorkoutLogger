package com.Workout.WorkoutLogger.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class JwtAuthenticatorFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(
    HttpServletRequest request,
    HttpServletResponse response,
    FilterChain filterChain
  )
    throws ServletException, IOException {
    final String authenticationHeader = request.getHeader("Authorization");
    final String jwt;
    final String userName;
    if (authenticationHeader == null || !authenticationHeader.startsWith("Bearer")) {
      filterChain.doFilter(request, response);
      return;
    }

    // 7 since Bearer len == 7
    jwt = authenticationHeader.substring(7);
    userName = JwtService.extractUserName(jwt);
  }
}
