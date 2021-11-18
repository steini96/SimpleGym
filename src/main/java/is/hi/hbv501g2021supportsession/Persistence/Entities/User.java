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
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    LoginInfo loginInfo;

    @OneToOne(fetch = FetchType.LAZY)
    UserFitnessInfo userFitnessInfo;

    public User() {
    }

    public User(String Name, String emailAddress, LoginInfo LoginInfo, UserFitnessInfo userFitnessInfo){
        this.name = Name;
        this.emailAddress = emailAddress;
        this.loginInfo = LoginInfo;
        this.userFitnessInfo = userFitnessInfo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getName() {
        return name;
    }

    public LoginInfo getLoginInfo() {

        return loginInfo;
    }

    public UserFitnessInfo getUserFitnessInfo() {
        return userFitnessInfo;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoginInfo(LoginInfo loginInfo) {

        this.loginInfo = loginInfo;
    }

    public void setUserFitnessInfo(UserFitnessInfo userFitnessInfo) {
        this.userFitnessInfo = userFitnessInfo;
    }
}