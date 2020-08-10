package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;

@Entity
@Table(name = "billing")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username ;

    @Column(name = "accountnumber")
    private String accountnumber;

    @Column(name = "time")
    private String time ;

    public Billing() {
    }

    public Billing(String username, String accountnumber, String time) {
        this.username = username;
        this.accountnumber = accountnumber;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", accountnumber='" + accountnumber + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
