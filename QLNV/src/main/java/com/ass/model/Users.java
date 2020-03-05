package com.ass.model;

import javax.persistence.*;

@Entity
@Table(name ="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String username;
    private String password;
    private String fullname;

    public Users() {
    }

    public Users(String password, String fullname) {
        this.password = password;
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

}
