package is.hi.hbv501g2021supportsession.Controllers;

import is.hi.hbv501g2021supportsession.Persistence.Entities.User;
import is.hi.hbv501g2021supportsession.Persistence.Entities.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import is.hi.hbv501g2021supportsession.Services.WorkoutService;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WorkoutController {

    WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @RequestMapping(value = "/work1", method = RequestMethod.GET)
    public User checkLoginUser(HttpSession session) {
        return null;
    }

    @RequestMapping(value = "/work2", method = RequestMethod.GET)
    public String seeUserWorkouts(HttpSession session, Model model) {
        return "";
    }

    @RequestMapping(value = "/work3", method = RequestMethod.GET)
    public String addWorkoutGET(Model timeModel) {
        return "";
    }

    @RequestMapping(value = "/work4", method = RequestMethod.GET)
    public String addWorkPOST(HttpSession session, Workout workout) {
        return "";
    }

    @RequestMapping(value = "/work5", method = RequestMethod.GET)
    public String changeWorkoutPOST(HttpSession session, Workout workout, Model model) {
        return "";
    }

}
