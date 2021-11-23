package is.hi.hbv501g2021supportsession.Services;

import is.hi.hbv501g2021supportsession.Persistence.Entities.LoginInfo;
import is.hi.hbv501g2021supportsession.Persistence.Entities.User;
import is.hi.hbv501g2021supportsession.Persistence.Entities.UserFitnessInfo;

import java.util.List;

public interface UserService {
    // Todo: Currently the Book object is used instead of the User object, needs to be substituted when User has been made
    User saveUser(User user); // Save user, need to pass user object into saveUser
    LoginInfo saveLoginInfo(LoginInfo loginInfo);
    UserFitnessInfo saveUserFitnessInfo(UserFitnessInfo userFitnessInfo);
    void deleteUser(User user); // Delete user
    User findUserByName(String Name); // find user by name
    User loginUser(User user); // Login user
    User logoutUser(User user); // Logout user

    // Todo: look into what would be good to pass into the login and logout functions
}
