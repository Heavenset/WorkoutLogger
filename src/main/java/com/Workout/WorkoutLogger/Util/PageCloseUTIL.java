package com.Workout.WorkoutLogger.Util;

import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;

public class PageCloseUTIL {

	public static void closePageAndRedirect(HttpServletResponse response, int delayInSeconds, String redirectUrl)
			throws IOException {
		
		try {
			Thread.sleep(delayInSeconds * 1000);
			response.sendRedirect(redirectUrl);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}
}
