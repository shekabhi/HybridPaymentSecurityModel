package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name="username")
    private String userName ;

    @Column(name="passward")
    private String passward ;

    public User() {
    }

    public User(String userName, String passward) {
        this.userName = userName;
        this.passward = passward;
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
                "userName='" + userName + '\'' +
                ", passward='" + passward + '\'' +
                '}';
    }
}
