package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.Profile;

public interface ProfileServices {
    void insertProfile(Profile profile);

    Profile findbyuser(String name);

    void updateProfile( String username , String name, String email, String number, String location);

    void updatePassword(String name, String encodedPassword);

    void deletebyUserName(String username);
}
