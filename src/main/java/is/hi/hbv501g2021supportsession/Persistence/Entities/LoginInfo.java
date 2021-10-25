package is.hi.hbv501g2021supportsession.Persistence.Entities;

import javax.persistence.*;

@Entity
@Table(name = "LoginInfo")
public class LoginInfo {
    private String password;
    @Id //ekki GUID, hvernig ættum við að græja það
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    public LoginInfo(String password, long ID) {
        this.password = password;
        this.ID = ID;
    }

    public LoginInfo() {
    }

    public String getPassword() {
        return password;
    }

    public long getID() {
        return ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
}
