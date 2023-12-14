package com.Workout.WorkoutLogger.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Oauth2Controller {

	@GetMapping("/workouts/account/login")
	public void initiateOAuth(HttpServletResponse response) throws IOException {
		// Perform OAuth2 initiation
		// E.g., redirect user to the OAuth provider's authentication page
		String oauthAuthorizationUrl = "https://oauth.provider.com/authorize?"
				+ "client_id=yourClientId&redirect_uri=yourRedirectUri&response_type=code";
		response.sendRedirect(oauthAuthorizationUrl);
	}
}
