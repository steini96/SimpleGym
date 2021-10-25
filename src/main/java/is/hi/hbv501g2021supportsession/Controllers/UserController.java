package is.hi.hbv501g2021supportsession.Controllers;

import is.hi.hbv501g2021supportsession.Persistence.Entities.Book;
import is.hi.hbv501g2021supportsession.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet(){
        // Returns login page
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(Book user, BindingResult result, Model model){
        if(result.hasErrors()) {
            return "login";
        }
        Book loggedInUser = userService.loginUser(user);
        // todo: catch loggedInUser error if any
        // todo: add user to Session

        return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOutGet(Book user) {
        Book loggedOutUser = userService.logoutUser(user);
        // todo: catch loggedOutUser error if any
        // todo: Session stuff
        return "redirect: /login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUpGet() {
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUpPost(Book user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "redirect: /signup";
        }
        Book newUser = userService.saveUser(user);
        // todo: Catch error of user already exists

        return "redirect: /login";
    }

    @RequestMapping(value = "/overview", method = RequestMethod.GET)
    public String overViewGet(Model model) {
        // todo: Get user from session
        return "";
    }
    public String comparisonGet(){
        return "";
    }

}
