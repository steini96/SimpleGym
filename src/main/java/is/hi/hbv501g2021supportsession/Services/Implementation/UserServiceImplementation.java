package is.hi.hbv501g2021supportsession.Services.Implementation;

import is.hi.hbv501g2021supportsession.Persistence.Entities.User;
import is.hi.hbv501g2021supportsession.Persistence.Repositories.UserRepository;
import is.hi.hbv501g2021supportsession.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class UserServiceImplementation implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Todo: substitute bookRepository for userRepository when it is ready
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userRepository.findByTitle(name);
    } // Todo: substitute with findByName when it exists

    @Override
    public User loginUser(User user) {
        return userRepository.save(user);
    } // Todo: substitute save with login

    @Override
    public User logoutUser(User user) {
        return userRepository.save(user);
    } // Todo: substitute save with logout

}
