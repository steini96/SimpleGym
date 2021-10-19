package is.hi.hbv501g2021supportsession.Services;

import is.hi.hbv501g2021supportsession.Persistence.Entities.Book;

import java.util.List;

public interface UserService {
    // Todo: Currently the Book object is used instead of the User object, needs to be substituted when User has been made
    Book saveUser(Book user); // Save user, need to pass user object into saveUser
    void deleteUser(Book user); // Delete user
    List<Book> findUserByName(String name); // find user by name
    Book loginUser(Book user); // Login user
    Book logoutUser(Book user); // Logout user

    // Todo: look into what would be good to pass into the login and logout functions
}
