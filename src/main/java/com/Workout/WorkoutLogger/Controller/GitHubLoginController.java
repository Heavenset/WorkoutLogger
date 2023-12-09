package com.Workout.WorkoutLogger.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GitHubLoginController {

	@Autowired
	private OAuth2AuthorizedClientService authorizedClientService;

	@GetMapping("/login/oauth2/code/github")
	public String gitHubLoginCallback(Authentication authentication,
			@RegisteredOAuth2AuthorizedClient("github") OAuth2AuthorizedClient authorizedClient) {
// Handle the GitHub login callback, process the response, and retrieve user information
// Redirect the user to the main page after successfully processing the GitHub login callback
		return "redirect:/";
	}
}
