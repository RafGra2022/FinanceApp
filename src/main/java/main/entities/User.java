package main.entities;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="user")
    private String user;

    @Column(name="password")
    private String password;

    public User() {

    }

    public String getUser() {
        return user;
    }

    public void setId(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [user=" + user + ", password=" + password  + "]";
    }
}

