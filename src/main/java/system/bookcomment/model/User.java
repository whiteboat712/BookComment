package system.bookcomment.model;

import java.beans.JavaBean;

@JavaBean
public class User {

    /*用户id*/
    int uid;
    /*用户名*/
    String uname;
    /*用户密码*/
    String password;

    Role role;

    String avatar;

    public enum Role {
        ADMIN, USER
    }

    public User(int uid, String uname, String password, Role role, String avatar) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.role = role;
        this.avatar = avatar;
    }

    public User() {

    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
