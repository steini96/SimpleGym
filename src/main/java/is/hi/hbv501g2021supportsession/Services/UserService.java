package is.hi.hbv501g2021supportsession.Services;

import is.hi.hbv501g2021supportsession.Persistence.Entities.LoginInfo;
import is.hi.hbv501g2021supportsession.Persistence.Entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user); // Save user, need to pass user object into saveUser
    LoginInfo saveLoginInfo(LoginInfo loginInfo);
    void deleteUser(User user); // Delete user
    User findUserByName(String Name); // find user by name
    User hashPassword(User user);
    String comparePasswords(User existingUser, User user);
}
