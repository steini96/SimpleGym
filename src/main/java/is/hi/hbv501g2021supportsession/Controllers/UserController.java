package is.hi.hbv501g2021supportsession.Controllers;

import is.hi.hbv501g2021supportsession.Persistence.Entities.LoginInfo;
import is.hi.hbv501g2021supportsession.Persistence.Entities.User;
import is.hi.hbv501g2021supportsession.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

@Controller
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model, HttpSession session){
        // Returns login page
        if(session.getAttribute("loggedInUser") != null) {
            return "loggedInPage";
        }
        model.addAttribute("user",new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(User user, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()) {
            return "login";
        }
        String errorMsg = "";
        User existingUser = userService.findUserByName(user.getName());
        if (existingUser != null) {
            String passwords = comparePasswords(existingUser, user);

            if (passwords.equals("match")) {
                session.setAttribute("LoggedInUser", existingUser);
                model.addAttribute("LoggedInUser", existingUser);
                return "loggedInPage";
            }
            if (passwords.equals("noMatch")) {
                errorMsg = "Username and password don't match";
            }
            if (passwords == null) {
                errorMsg = "Error: try again";
            }
        } else {
            errorMsg = "Username does not exist";
        }

        /// When password does not match
        model.addAttribute("loginError", errorMsg);
        return loginPage(model,session);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOutUser(User user, HttpSession session) {
        User loggedOutUser = userService.logoutUser(user);
        session.removeAttribute("LoggedInUser");
        return "redirect:/login";
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

        User exists = userService.findUserByName(user.getName());
        // Catch error of username already exists
        if(exists != null) {
            model.addAttribute("signupError", "Error: Username taken");
            return signUpPage(model);
        }

        User newUser = hashPassword(user);
        if(newUser == null) {
            model.addAttribute("signupError", "Error: Try again");
            return signUpPage(model);
        }

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

    @RequestMapping(value = "/overview", method = RequestMethod.GET)
    public String overViewGet(Model model) {
        // todo: Get user from session
        return "";
    }
    public String comparisonGet(){
        return "";
    }

    private User hashPassword(User user) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(user.getLoginInfo().getPassword().toCharArray(), salt, 65536, 128);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            String hashBase64encoded = Base64.getEncoder().encodeToString(hash);
            user.getLoginInfo().setPassword(hashBase64encoded);
            user.getLoginInfo().setSalt(salt);
            return user;

        } catch (Exception e) {
            System.out.println("Error in hashing");
            return null;
        }
    }

    private String comparePasswords(User existingUser, User user) {
        LoginInfo existingUserInfo = existingUser.getLoginInfo();
        String existingPassHash = existingUserInfo.getPassword();
        byte[] salt = existingUserInfo.getSalt();

        try {
            KeySpec newSpec = new PBEKeySpec(user.getLoginInfo().getPassword().toCharArray(), salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(newSpec).getEncoded();
            String newHash = Base64.getEncoder().encodeToString(hash);

            if(existingPassHash.equals(newHash)) {
                return "match";
            }
            return "noMatch";
        } catch (Exception e) {
            return null;
        }
    }

}