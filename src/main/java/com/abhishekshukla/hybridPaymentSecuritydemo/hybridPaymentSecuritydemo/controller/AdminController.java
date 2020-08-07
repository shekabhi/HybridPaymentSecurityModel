package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {

    @RequestMapping(value = "/home")
    public String adminpage(){return  "home" ;}
}
