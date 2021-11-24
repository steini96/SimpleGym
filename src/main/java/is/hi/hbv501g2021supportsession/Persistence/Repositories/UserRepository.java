package is.hi.hbv501g2021supportsession.Persistence.Repositories;

import is.hi.hbv501g2021supportsession.Persistence.Entities.LoginInfo;
import is.hi.hbv501g2021supportsession.Persistence.Entities.User;
import is.hi.hbv501g2021supportsession.Persistence.Entities.UserFitnessInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);
    LoginInfo save(LoginInfo loginInfo);
    UserFitnessInfo save(UserFitnessInfo userFitnessInfo);
    void delete(User user);

    List<User> findAll();
    List<User> findByID(String title);
    User findUserByName(String name);
}
