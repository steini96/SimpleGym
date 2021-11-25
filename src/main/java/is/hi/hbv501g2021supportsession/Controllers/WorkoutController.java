package is.hi.hbv501g2021supportsession.Controllers;

import is.hi.hbv501g2021supportsession.Persistence.Entities.*;
import is.hi.hbv501g2021supportsession.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import is.hi.hbv501g2021supportsession.Services.WorkoutService;
import is.hi.hbv501g2021supportsession.Services.ExerciseService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WorkoutController {

    WorkoutService workoutService;
    UserService userService;
    ExerciseService exerciseService;

    @Autowired
    public WorkoutController(WorkoutService workoutService, ExerciseService exerciseService) {
        this.workoutService = workoutService;
        this.exerciseService = exerciseService;
    }

    @RequestMapping(value = "/checkLoggedIn", method = RequestMethod.GET)
    public User checkLoginUser(HttpSession session) {
         User sessionUser = (User) session.getAttribute("LoggedInUser");
         return sessionUser;
    }

    @RequestMapping(value = "/updateUserFitnessInfo", method = RequestMethod.GET)
    public String getUserFitnessInfo(HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if (sessionUser == null){
            System.out.println("loggin");
            return "home";
        }

        model.addAttribute("userFitnessInfo", new UserFitnessInfo());
        return "getUserFitnessInfo";

    }

    @RequestMapping(value = "/addUserFitnessInfo", method = RequestMethod.POST)
    public String addUserFitnessInfo(UserFitnessInfo userFitnessInfo,  BindingResult result, Model model, HttpSession session){
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        sessionUser.setUserFitnessInfo(userFitnessInfo);
        return "redirect:/home";
    }

    @RequestMapping(value = "/getWorkout", method = RequestMethod.GET)
    public String seeUserWorkouts(HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");

        UserFitnessInfo userFitnessInfo = sessionUser.getUserFitnessInfo();
        long userFitnessInfoId = userFitnessInfo.getId();


        List<Workout> workouts =  workoutService.findAll();

        //Workout[] workoutArray = new Workout[workouts.size()];
        /*Object[] workoutArray = workouts.toArray();
        Workout workout = workouts.get(0);
        for(int i = 0; i<workouts.size();i++){
            if(workouts.get(i).getUserFitnessInfo().getId() == userFitnessInfoId){
                workout = workouts.get(i);
            }
        }*/

        List<Exercise> exercises =  exerciseService.findAll();

        List<Exercise> exerciseList = new ArrayList<Exercise>();
        for(int i = 0; i<exercises.size();i++){
            if(exercises.get(i).getWorkout().getWorkoutType() == userFitnessInfo.getWorkoutType() && exercises.get(i).getWorkout().getDifficulty() == userFitnessInfo.getDifficulty()){
                exerciseList.add(exercises.get(i));
            }
        }



        // List<Exercise> exercises = workoutService.findAll("");

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
                model.addAttribute("exerciseList", exerciseList);
            }
            model.addAttribute("exerciseList", exerciseList);
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
