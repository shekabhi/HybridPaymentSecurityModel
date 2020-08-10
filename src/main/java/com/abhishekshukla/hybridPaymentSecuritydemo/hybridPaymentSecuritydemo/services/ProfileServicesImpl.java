package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.db.ProfileRepository;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ProfileServicesImpl implements ProfileServices {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public void insertProfile(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public Profile findbyuser(String name) {
        return profileRepository.findbyUser(name);
    }

    @Override
    public void updateProfile(String username ,String name, String email, String number, String location) {
        profileRepository.upadateProfile(username ,name , email , number , location);
    }

    @Override
    public void updatePassword(String name, String encodedPassword) {
        profileRepository.updatePassword(name , encodedPassword);
    }

    @Override
    public void deletebyUserName(String username) {
        profileRepository.deleteById(username);
    }
}
