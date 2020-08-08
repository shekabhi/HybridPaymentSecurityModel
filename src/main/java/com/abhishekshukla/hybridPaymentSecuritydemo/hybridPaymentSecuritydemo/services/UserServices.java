package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.User;

import java.util.List;

public interface UserServices {
    public void insertUser(User user);

    public List<User> findAllbyRole(String role);

    public void deletebyUserName(String username);
}
