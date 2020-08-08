package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.db.UserRepository;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void insertUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAllbyRole(String role) {
        return userRepository.findAllbyRole(role) ;
    }

    @Override
    public void deletebyUserName(String username) {
        userRepository.deleteById(username);
    }
}
