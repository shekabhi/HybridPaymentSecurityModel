package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.security;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.db.UserRepository;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDeatailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(userName);

        if(user==null){
            throw  new UsernameNotFoundException("404 Error");
        }

        return new UserPrincipal(user) ;
    }
}
