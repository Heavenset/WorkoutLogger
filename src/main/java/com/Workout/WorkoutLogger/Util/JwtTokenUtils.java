package com.Workout.WorkoutLogger.Util;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtils {
	private final String secret;
    private final Duration jwtLifetime;

    @Autowired
    public JwtTokenUtils(@Value("${jwt.secret}") String secret, @Value("${jwt.lifetime}") Duration jwtLifetime) {
        this.secret = secret;
        this.jwtLifetime = jwtLifetime;
    }

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		List<String> rolesList = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());
		claims.put("roles", rolesList);

		Date issuedDate = new Date();
		Date expiredDate = new Date(issuedDate.getTime() + jwtLifetime.toMillis());
		return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername()).setIssuedAt(issuedDate)
				.setExpiration(expiredDate).signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public String getUsername(String token) {
		return getAllClaimsFromToken(token).getSubject();
	}

	public List<String> getRoles(String token) {
		return getAllClaimsFromToken(token).get("roles", List.class);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).build().parseClaimsJws(token).getBody();
	}
}
