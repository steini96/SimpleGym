package is.hi.hbv501g2021supportsession.Persistence.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String emailAddress;
    private String Name;

    @OneToOne(fetch = FetchType.LAZY)
    LoginInfo LoginInfo;

    @OneToOne(fetch = FetchType.LAZY)
    UserFitnessInfo userFitnessInfo;

    public User() {
    }

    public User(String Name, String emailAddress, LoginInfo LoginInfo, UserFitnessInfo userFitnessInfo){
        this.Name = Name;
        this.emailAddress = emailAddress;
        this.LoginInfo = LoginInfo;
        this.userFitnessInfo = userFitnessInfo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getName() {
        return Name;
    }

    public is.hi.hbv501g2021supportsession.Persistence.Entities.LoginInfo getLoginInfo() {
        return LoginInfo;
    }

    public UserFitnessInfo getUserFitnessInfo() {
        return userFitnessInfo;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setLoginInfo(is.hi.hbv501g2021supportsession.Persistence.Entities.LoginInfo loginInfo) {
        LoginInfo = loginInfo;
    }

    public void setUserFitnessInfo(UserFitnessInfo userFitnessInfo) {
        this.userFitnessInfo = userFitnessInfo;
    }
}
