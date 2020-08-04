package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model;

import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name = "accountnumber")
    private String accountnumber ;

    @Column(name = "username")
    private String username ;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "expdate")
    private String expdate ;

    public Card() {
    }

    public Card(String accountnumber, String username, String firstname, String lastname, String expdate) {
        this.accountnumber = accountnumber;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.expdate = expdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", accountnumber='" + accountnumber + '\'' +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", expdate='" + expdate + '\'' +
                '}';
    }
}
