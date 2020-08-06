package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.db.UserRepository;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void insertUser(User user) {
        userRepository.save(user);
    }
}
