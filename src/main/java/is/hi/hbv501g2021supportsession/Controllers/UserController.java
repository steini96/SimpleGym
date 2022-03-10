package is.hi.hbv501g2021supportsession.Controllers;

import is.hi.hbv501g2021supportsession.Persistence.Entities.LoginInfo;
import is.hi.hbv501g2021supportsession.Persistence.Entities.User;
import is.hi.hbv501g2021supportsession.Persistence.Entities.UserFitnessInfo;
import is.hi.hbv501g2021supportsession.Persistence.Entities.Workout;
import is.hi.hbv501g2021supportsession.Services.UserService;
import is.hi.hbv501g2021supportsession.Services.WorkoutService;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {

    UserService userService;
    WorkoutService workoutService;

    @Autowired
    public UserController(UserService userService, WorkoutService workoutService) {
        this.userService = userService;
        this.workoutService = workoutService;
    }

    /***
     *
     *  TESTING TESTING
     * */
    @GetMapping("/foo")
    public @ResponseBody User foo(){
        LoginInfo loginInfo = new LoginInfo("PassiðHansMagga");
        UserFitnessInfo userFitnessInfo = new UserFitnessInfo();

        User usr = new User("Magnús Þór", "Maggi@mix.ru", loginInfo, userFitnessInfo);
        return usr;
    }

//    @PostMapping("/login")
//    User @ResponseBody loginUser(@RequestBody User user) {
//        System.out.println(user.getName());
//        String errorMsg = "";
//        User existingUser = userService.findUserByName(user.getName());
//        if (existingUser != null) {
//            String passwords = userService.comparePasswords(existingUser, user);
//            if (passwords == null) {
////                return {"error":"Ers"};
//                return ResponseEntity<>.notFound().build();
//            }
//            else {
//                if (passwords.equals("match")) {
//                    session.setAttribute("LoggedInUser", existingUser);
//                    model.addAttribute("LoggedInUser", existingUser);
//                }
//                if (passwords.equals("noMatch")) {
//                    errorMsg = "Username and password don't match";
//                }
//            }
//
//        } else {
//            errorMsg = "Username does not exist";
//        }
//
//    }




    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOutUser(HttpSession session) {
        session.removeAttribute("LoggedInUser");
        return "redirect:/";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUpPage(Model model) {
        model.addAttribute("newUser",new User());
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUpUser(User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "redirect:/signup";
        }
        System.out.println("Username: " + user.getName());
        System.out.println("Password: " + user.getLoginInfo().getPassword());
        System.out.println("Difficulty: " + user.getUserFitnessInfo().getDifficulty().toString());


        if(user.getUserFitnessInfo() != null) {
            List<Workout> allWorkouts = workoutService.findAll();
            System.out.println(allWorkouts.get(0).getWorkoutName());
            user.getUserFitnessInfo().setWorkouts(allWorkouts);
        }

        System.out.println("Workout 0: " + user.getUserFitnessInfo().getWorkouts().get(0).getWorkoutName());
        System.out.println("Workout 1: " + user.getUserFitnessInfo().getWorkouts().get(1).getWorkoutName());

        User exists = userService.findUserByName(user.getName());
        // Catch error of username already exists
        if(exists != null) {
            model.addAttribute("signupError", "Error: Username taken");
            return signUpPage(model);
        }

        User newUser = userService.hashPassword(user);
        if(newUser == null) {
            model.addAttribute("signupError", "Error: Try again");
            return signUpPage(model);
        }

        userService.saveUserFitnessInfo(newUser.getUserFitnessInfo());
        userService.saveLoginInfo(newUser.getLoginInfo());
        userService.saveUser(newUser);
        return "redirect:/login";
    }

    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
    public String loggedinGET(HttpSession session, Model model){
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if(sessionUser  != null){
            model.addAttribute("LoggedInUser", sessionUser);
            return "loggedInPage";
        }
        return "redirect:/";
    }


}