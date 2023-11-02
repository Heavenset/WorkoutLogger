package com.Workout.WorkoutLogger.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Workout.WorkoutLogger.Model.Workout;
import com.Workout.WorkoutLogger.Repository.WorkoutRepository;

@Controller
public class WorkoutController {

	@Autowired
	private WorkoutRepository workoutRepository;

	@GetMapping(value = "/workouts")
	public ModelAndView workout(Model model) {
		Iterable<Workout> workout = workoutRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("home");
		// It may cause a bug so i have to look for it
		modelAndView.addObject("posts", workout);
		return modelAndView;
	}
	
	@GetMapping(value = "/workouts/add")
	public String home(Model model) {
		return "workout-add";
	}
}