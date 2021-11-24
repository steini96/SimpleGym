package is.hi.hbv501g2021supportsession.Services.Implementation;

import is.hi.hbv501g2021supportsession.Persistence.Entities.LoginInfo;
import is.hi.hbv501g2021supportsession.Persistence.Entities.User;
import is.hi.hbv501g2021supportsession.Persistence.Entities.UserFitnessInfo;
import is.hi.hbv501g2021supportsession.Persistence.Repositories.UserRepository;
import is.hi.hbv501g2021supportsession.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

@Service
public class UserServiceImplementation implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public LoginInfo saveLoginInfo(LoginInfo loginInfo) {
        return userRepository.save(loginInfo);
    }

    @Override
    public UserFitnessInfo saveUserFitnessInfo(UserFitnessInfo userFitnessInfo) {
        return userRepository.save(userFitnessInfo);
    }


    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public User hashPassword(User user) {
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

    @Override
    public String comparePasswords(User existingUser, User user) {
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
            System.out.println("ERROR:::::");
            System.out.println(e);
            return null;
        }
    }
}
