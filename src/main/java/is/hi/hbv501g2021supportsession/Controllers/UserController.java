package is.hi.hbv501g2021supportsession.Controllers;

import is.hi.hbv501g2021supportsession.Persistence.Entities.LoginInfo;
import is.hi.hbv501g2021supportsession.Persistence.Entities.User;
import is.hi.hbv501g2021supportsession.Persistence.Entities.UserFitnessInfo;
import is.hi.hbv501g2021supportsession.Persistence.Entities.Workout;
import is.hi.hbv501g2021supportsession.Services.UserService;
import is.hi.hbv501g2021supportsession.Services.WorkoutService;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public User foo(){
        LoginInfo loginInfo = new LoginInfo("PassiðHansMagga");
        UserFitnessInfo userFitnessInfo = new UserFitnessInfo();

        User usr = new User("Magnús Þór", "Maggi@mix.ru", loginInfo, userFitnessInfo);
        return usr;
    }

//
//    @PostMapping("/login")
//    User @ResponseBody loginUser( @ResponseBody User user) {
//        System.out.println(user.getName());
//        String errorMsg = "";
//        User existingUser = userService.findUserByName(user.getName());
//        if (existingUser != null) {
//            String passwords = userService.comparePasswords(existingUser, user);
//            if (passwords == null) {
////                return {"error":"Ers"};
//                JSONObject();
//                return ResponseEntity.notFound().build();
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



    @PostMapping(path= "/signup",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> signUpUser(@RequestBody User user) {

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
        if(exists != null) {
            // Username exists
            return null;
        }

        User newUser = userService.hashPassword(user);

        if(newUser == null) {
            // Signup Error
            return null;
        }

        userService.saveUserFitnessInfo(newUser.getUserFitnessInfo());
        userService.saveLoginInfo(newUser.getLoginInfo());
        userService.saveUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
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