package is.hi.hbv501g2021supportsession.Controllers;

import is.hi.hbv501g2021supportsession.Persistence.Entities.User;
import is.hi.hbv501g2021supportsession.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet(User user,Model model){
        // Returns login page
        model.addAttribute("user",user);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(User user, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()) {
            return "login";
        }
        User loggedInUser = userService.loginUser(user);
        if(loggedInUser != null) {
            session.setAttribute("LoggedInUser", loggedInUser);
            model.addAttribute("LoggedInUser", loggedInUser);
            return "loggedInPage";
        }

        return "redirect:/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOutGet(User user) {
        User loggedOutUser = userService.logoutUser(user);
        // todo: catch loggedOutUser error if any
        // todo: Session stuff
        return "redirect:/login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUpGet() {
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUpPost(User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "redirect:/signup";
        }
        List<User> exists = userService.findUserByName(user.getTitle()); //user.getName()
        // Catch error of username already exists
        String username = user.getName();
        for (User usr:exists) {
            if(usr.getName() == username) {
                System.out.println("Username taken");
                return "redirect:/signup";
            }
        }
        User newUser = userService.saveUser(user);
        return "redirect: /login";
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

    @RequestMapping(value = "/overview", method = RequestMethod.GET)
    public String overViewGet(Model model) {
        // todo: Get user from session
        return "";
    }
    public String comparisonGet(){
        return "";
    }

}
*/