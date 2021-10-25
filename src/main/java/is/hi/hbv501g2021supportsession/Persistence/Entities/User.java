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

    public User(String Name, String emailAddress, LoginInfo LoginInfo){
        this.Name = Name;
        this.emailAddress = emailAddress;
        this.LoginInfo = LoginInfo;
    }
}
