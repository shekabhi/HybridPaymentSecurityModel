package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.controller;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.Card;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.User;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services.CardServices;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private CardServices cardServices;

    @RequestMapping("home")
    public String adminpage(Model model){

        model.addAttribute("users" , userServices.findAllbyRole("USER"));

        return  "admin/home" ;
    }

    //delete User
    @RequestMapping("removeuser/{username}")
    public String removeduser (@PathVariable String username) {

        userServices.deletebyUserName(username);

        return "redirect:/admin/home";
    }

    @RequestMapping("usercarddetail/{username}")
    public String userCardDetail(Model model , @PathVariable String username){

        model.addAttribute("usercards" , cardServices.findAllbyId(username) );

        return  "admin/usercarddetail" ;
    }

}
