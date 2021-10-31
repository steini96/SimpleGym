package is.hi.hbv501g2021supportsession.Controllers;

import is.hi.hbv501g2021supportsession.Persistence.Entities.User;
import is.hi.hbv501g2021supportsession.Persistence.Entities.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import is.hi.hbv501g2021supportsession.Services.WorkoutService;

import javax.servlet.http.HttpSession;

@Controller
public class WorkoutController {

    WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @RequestMapping()
    public User checkLoginUser(HttpSession session) {
        return null;
    }

    @RequestMapping()
    public String seeUserWorkouts(HttpSession session, Model model) {
        return "";
    }

    @RequestMapping()
    public String addWorkoutGET(Model timeModel) {
        return "";
    }

    @RequestMapping()
    public String addWorkPOST(HttpSession session, Workout workout) {
        return "";
    }

    @RequestMapping()
    public String changeWorkoutPOST(HttpSession session, Workout workout, Model model) {
        return "";
    }

}
