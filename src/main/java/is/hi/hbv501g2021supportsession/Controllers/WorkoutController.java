package is.hi.hbv501g2021supportsession.Controllers;

import is.hi.hbv501g2021supportsession.Persistence.Entities.*;
import is.hi.hbv501g2021supportsession.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import is.hi.hbv501g2021supportsession.Services.WorkoutService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WorkoutController {

    WorkoutService workoutService;
    UserService userService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @RequestMapping(value = "/checkLoggedIn", method = RequestMethod.GET)
    public User checkLoginUser(HttpSession session) {
         User sessionUser = (User) session.getAttribute("LoggedInUser");
         return sessionUser;
    }

    @RequestMapping(value = "/getUserFitnessInfo", method = RequestMethod.GET)
    public String getUserFitnessInfo(HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if (sessionUser == null){
            return "home";
        }
        else if(sessionUser.getUserFitnessInfo() == null){
            model.addAttribute("userFitnessInfo", new UserFitnessInfo());
            return "getUserFitnessInfo";
        }
        return "home";
    }

    @RequestMapping(value = "/addUserFitnessInfo", method = RequestMethod.POST)
    public String addUserFitnessInfo(UserFitnessInfo userFitnessInfo,  BindingResult result, Model model, HttpSession session){
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        sessionUser.setUserFitnessInfo(userFitnessInfo);
        System.out.println(sessionUser.getUserFitnessInfo().getNumWeeklyWrkOut());
        System.out.println(sessionUser.getUserFitnessInfo().getDifficulty());
        System.out.println(sessionUser.getUserFitnessInfo().getWorkoutType());
        return "redirect:/";
    }

    @RequestMapping(value = "/getWorkout", method = RequestMethod.GET)
    public String seeUserWorkouts(HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        System.out.println(sessionUser.getUserFitnessInfo());
        System.out.println("Staður1");
        if (sessionUser == null){
            model.addAttribute("workoutType", "ekkert1");
            System.out.println("Staður2");
            return "home";
        }
        if(sessionUser.getUserFitnessInfo() == null){
            model.addAttribute("userFitnessInfo", new UserFitnessInfo());
            model.addAttribute("workoutType", "ekkert2");
            System.out.println("Staður3");
            return "workout";
        }else{
            WorkoutType workoutType = sessionUser.getUserFitnessInfo().getWorkoutType();
            Difficulty workoutDifficulty = sessionUser.getUserFitnessInfo().getDifficulty();
            System.out.println("Staður4");
            System.out.println(workoutDifficulty);
            if(workoutType == null && workoutDifficulty == null){
                model.addAttribute("workoutType", workoutDifficulty);
            }
            model.addAttribute("workoutType", workoutDifficulty);
        }
        System.out.println("Staður5");
        return "workout";
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
