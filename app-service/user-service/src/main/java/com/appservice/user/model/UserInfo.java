package com.appservice.user.model;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.List;
import java.util.Queue;

@Entity
public class UserInfo   {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String role;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> previousPassword;

    public List<String> getPreviousPassword() {
        return previousPassword;
    }

    public void setPreviousPassword(List<String> previousPassword) {
        this.previousPassword = previousPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userID) {
        this.userId = userID;
    }

    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
