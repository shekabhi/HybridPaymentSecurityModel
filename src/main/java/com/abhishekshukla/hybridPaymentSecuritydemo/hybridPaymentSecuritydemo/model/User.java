package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name="user_id")
    private String userId ;

    @Column(name="user_name")
    private String userName ;

    @Column(name="passward")
    private String passward ;

    public User() {
    }

    public User(String userId, String userName, String passward) {
        this.userId = userId;
        this.userName = userName;
        this.passward = passward;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", passward='" + passward + '\'' +
                '}';
    }
}
