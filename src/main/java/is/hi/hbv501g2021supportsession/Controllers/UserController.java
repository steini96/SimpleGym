package is.hi.hbv501g2021supportsession.Controllers;

import is.hi.hbv501g2021supportsession.Persistence.Entities.LoginInfo;
import is.hi.hbv501g2021supportsession.Persistence.Entities.User;
import is.hi.hbv501g2021supportsession.Persistence.Entities.UserFitnessInfo;
import is.hi.hbv501g2021supportsession.Services.UserService;
import is.hi.hbv501g2021supportsession.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    /**
     * @param user
     * @return User og 200 Http status ef successful login
     *         annars skilar User sem hefur villuskilaboð sem nafn
     *         og 400 (Bad request)Http status
     */
    @PostMapping(path= "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> loginUser( @RequestBody User user) {
        System.out.println(user.getName());
        User existingUser = userService.findUserByName(user.getName());
        if (existingUser != null) {
            String passwords = userService.comparePasswords(existingUser, user);
            if (passwords == null) {
                User errorUser = new User();
                errorUser.setName("Incorrect password");
                return (new ResponseEntity<User>(errorUser,HttpStatus.BAD_REQUEST));
            } else {
                if (passwords.equals("match")) {
                    return (new ResponseEntity<User>(existingUser,HttpStatus.ACCEPTED));
                }
                if (passwords.equals("noMatch")) {
                    User errorUser = new User();
                    errorUser.setName("Username and password don't match");
                    return (new ResponseEntity<User>(errorUser,HttpStatus.BAD_REQUEST));
                }
            }

        }
        User errorUser = new User();
        errorUser.setName("Username does not exist");
        return (new ResponseEntity<>(errorUser,HttpStatus.BAD_REQUEST));
    }


    /**
     * @param user
     * @return User og 200 Http status ef successful signup
     *         annars skilar User sem hefur villuskilaboð sem nafn
     *         og 400 (Bad request)Http status
     */
    @PostMapping(path= "/signup",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> signUpUser(@RequestBody User user) {

        LoginInfo login = user.getLoginInfo();
        System.out.println(login.getPassword());

        User exists = userService.findUserByName(user.getName());
        if(exists != null) {
            // Username exists
            User errorUser = new User();
            errorUser.setName("Username taken");
            return (new ResponseEntity<>(errorUser, HttpStatus.BAD_REQUEST));
        }

        User newUser = userService.hashPassword(user);

        System.out.println(newUser.getLoginInfo().getSalt());
        if(newUser == null) {
            // Signup Error
            User errorUser = new User();
            errorUser.setName("Signup error");
            return (new ResponseEntity<>(errorUser,HttpStatus.BAD_REQUEST));
        }

        if (newUser.getUserFitnessInfo() != null) {
            userService.saveUserFitnessInfo(newUser.getUserFitnessInfo());
        }
        userService.saveLoginInfo(newUser.getLoginInfo());
        userService.saveUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.ACCEPTED);
    }

}