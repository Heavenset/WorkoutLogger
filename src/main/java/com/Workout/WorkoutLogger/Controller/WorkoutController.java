package com.Workout.WorkoutLogger.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Workout.WorkoutLogger.Model.Workout;
import com.Workout.WorkoutLogger.Repository.WorkoutRepository;

@Controller
public class WorkoutController {

	@Autowired
	private WorkoutRepository workoutRepository;

	@GetMapping(value = "/workouts")
	public ModelAndView showWorkouts(Model model) {
		Iterable<Workout> workouts = workoutRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("main-page");
		// It may cause a bug so i have to look for it
		modelAndView.addObject("workouts", workouts);
		return modelAndView;
	}

	@GetMapping("/workouts/add")
	public String showAddWorkout() {
		return "workout-add";
	}

	@PostMapping(value = "/workouts/add")
	public String addWorkout(@RequestParam("title") String workout_title,
			@RequestParam("workout_description") String workout_description) {
		Workout workout = new Workout();
		workout.setName(workout_title);
		workout.setWorkoutDescription(workout_description);
		workoutRepository.save(workout);
		return "redirect:/workouts/add";
	}

	@GetMapping("/workouts/{id}")
	public ModelAndView getWorkoutDetails(@PathVariable Long id) {
		Workout workout = workoutRepository.findById(id).orElse(null);

		ModelAndView modelAndView = new ModelAndView("workout-showcase");
		modelAndView.addObject("workouts", workout);
		return modelAndView;
	}

}
