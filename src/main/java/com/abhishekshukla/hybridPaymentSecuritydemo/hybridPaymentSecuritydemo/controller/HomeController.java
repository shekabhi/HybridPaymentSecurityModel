package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.controller;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.User;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private UserServices userServices;


    @RequestMapping(value = "/")
    public String index(){
        return "home";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/signin")
    public String signin(){
        return "signin";
    }

    @PostMapping(value = "/newuser")
    public String newUser(@RequestParam("username") String username,
                          @RequestParam("passward") String passward){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

        User user = new User();

        user.setUserName(username);
        user.setPassward(passwordEncoder.encode(passward));
        user.setRoles("USER");
        userServices.insertUser(user);

        return "redirect:/login";
    }

}
