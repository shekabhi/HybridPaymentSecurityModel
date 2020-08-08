package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name="username")
    private String userName ;

    @Column(name="passward")
    private String passward ;

    @Column(name="roles")
    private String roles = "";

    public User() {
    }

    public User(String userName, String passward, String roles) {
        this.userName = userName;
        this.passward = passward;
        this.roles = roles;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<String> getRolesList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();

    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passward='" + passward + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
