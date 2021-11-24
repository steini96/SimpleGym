package is.hi.hbv501g2021supportsession.Persistence.Entities;

import javax.persistence.*;

@Entity
@Table(name = "loginInfo")
public class LoginInfo {
    private String password;
    private byte[] salt;
    @Id //ekki GUID, hvernig ættum við að græja það
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;


    public LoginInfo(String password, long ID, byte[] salt) {
            this.password = password;
            this.ID = ID;
            this.salt = salt;
        }

    public LoginInfo(String password){
        this.password = password;
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

        public byte[] getSalt() { return salt;}

        public void setSalt(byte[] salt) {this.salt = salt;}
    }

