package com.Workout.WorkoutLogger.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
				.oauth2Login(oauth2Login -> oauth2Login.loginPage("/login").permitAll()
						.clientRegistrationRepository(githubClientRegistrationRepository()));

		return http.build();
	}

	@Bean
	public ClientRegistrationRepository githubClientRegistrationRepository() {
		return new InMemoryClientRegistrationRepository(githubClientRegistration());
	}

	private ClientRegistration githubClientRegistration() {
		// Configure the OAuth2 client registration details for GitHub
		return ClientRegistration.withRegistrationId("github").clientSecret("f5098c4b23968f1b122bdc30a6096d711d7ce41b")
				.clientId("1a220061177ec370e0c0").redirectUri("/workouts")
				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE).scope("read:user")
				.authorizationUri("https://github.com/login/oauth/authorize")
				.tokenUri("https://github.com/login/oauth/access_token").userInfoUri("https://api.github.com/user")
				.userNameAttributeName("id").clientName("GitHub").build();
	}

}
