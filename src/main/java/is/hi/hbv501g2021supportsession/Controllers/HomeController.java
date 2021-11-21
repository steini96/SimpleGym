package is.hi.hbv501g2021supportsession.Controllers;


import is.hi.hbv501g2021supportsession.Persistence.Entities.Workout;
import is.hi.hbv501g2021supportsession.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {
    private WorkoutService workoutService;

    @Autowired
    public HomeController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @RequestMapping("/s")
    public String homePage(Model model){
        //Call a method in a Service Class
        List<Workout> allWorkouts = workoutService.findAll();
        //Add some data to the Model
        model.addAttribute("workouts", allWorkouts);
        return "home";
    }


    @RequestMapping(value = "/addWorkout", method = RequestMethod.GET)
    public String addBookForm(Workout workout){

        return "addWorkout";
    }

    @RequestMapping(value = "/addWorkout", method = RequestMethod.POST)
    public String addBook(Workout workout, BindingResult result, Model model){
        if(result.hasErrors()){
            return "addWorkout";
        }
        workoutService.save(workout);
        return "redirect:/";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") long id, Model model){
        Workout workoutToDelete = workoutService.findByID(id);
        workoutService.delete(workoutToDelete);
        return "redirect:/";
    }
}
