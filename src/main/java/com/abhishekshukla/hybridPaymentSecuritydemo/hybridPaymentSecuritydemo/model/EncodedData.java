package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model;

import javax.crypto.SecretKey;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "secretinfo")
public class EncodedData {

    @Id
    @Column(name="accountnumber")
    private String accountnumber;

    @Column(name="secretkey")
    private String secretKey ;

    public EncodedData() {
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public String toString() {
        return "EncodedData{" +
                "accountnumber='" + accountnumber + '\'' +
                ", secretKey='" + secretKey + '\'' +
                '}';
    }
}
