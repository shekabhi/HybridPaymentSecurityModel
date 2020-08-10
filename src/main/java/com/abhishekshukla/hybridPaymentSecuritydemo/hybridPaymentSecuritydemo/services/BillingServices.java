package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.Billing;

import java.util.List;

public interface BillingServices {

    public List<Billing> findAllbyId(String username) ;


    void insertBillLog(Billing billing);

    void deletebyUserName(String username);
}
