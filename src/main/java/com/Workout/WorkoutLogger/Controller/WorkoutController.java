package com.Workout.WorkoutLogger.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Workout.WorkoutLogger.Entity.Workout;
import com.Workout.WorkoutLogger.Repository.WorkoutRepository;

@Controller
public class WorkoutController {

	@Autowired
	private WorkoutRepository workoutRepository;

	@GetMapping(value = "/")
	public String welcomePage() {
		return "welcome.html";
	}

	@GetMapping(value = "/workouts")
	public ModelAndView showWorkouts(Model model) {
		Iterable<Workout> workoutS = workoutRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("main-page");
		// It may cause a bug so i have to look for it
		modelAndView.addObject("workouts", workoutS);
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
		workout.setWorkoutName(workout_title);
		workout.setWorkoutDescription(workout_description);
		workoutRepository.save(workout);
		return "redirect:/workouts";
	}

	@GetMapping("/workouts/{id}/edit")
	public String showEditWorkout(@PathVariable(value = "id") long id) {
		if (!workoutRepository.existsById(id)) {
			return "redirect:/main-page";
		}
		return "workout-edit";
	}

	@PostMapping(value = "/workouts/{id}/edit")
	public String editWorkout(@PathVariable(value = "id") long id, @RequestParam("title") String workout_title,
			@RequestParam("workout_description") String workout_description) {
		Workout workoutModel = workoutRepository.findById(id).orElseThrow();

		if (!workout_title.isEmpty()) {
			workoutModel.setWorkoutName(workout_description);
		}
		else {
			workoutModel.setWorkoutName("None");
		}

		if (!workout_description.isEmpty()) {
			workoutModel.setWorkoutDescription(workout_description);
		}
		else {
			workoutModel.setWorkoutDescription("None");
		}
		workoutRepository.save(workoutModel);
		return "redirect:/workouts";
	}

	@PostMapping(value = "/workouts/{id}/delete")
	public String deleteWorkout(@PathVariable(value = "id") long id) throws IOException {
		Workout workoutModel = workoutRepository.findById(id).orElseThrow();
		workoutRepository.delete(workoutModel);
		return "workout-delete-LABEL.html";
	}
}
