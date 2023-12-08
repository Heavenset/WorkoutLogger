package com.Workout.WorkoutLogger.Model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "user")
public class UserModel implements UserDetails {
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String name;
	private String userName;
	private String email;
	private String password;
	private boolean locked = true;
	private boolean enabled = true;
	@Enumerated(EnumType.STRING)
	private UserRoles userRoles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(userRoles.name()));

	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}