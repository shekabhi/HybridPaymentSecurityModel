package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.controller;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.Billing;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.Card;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.User;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private CardServices cardServices;

    @Autowired
    private SecretKeyServices secretKeyServices;

    @Autowired
    private ProfileServices profileServices;

    @Autowired
    private BillingServices billingServices;

    @RequestMapping("home")
    public String adminpage(Model model){

        model.addAttribute("users" , userServices.findAllbyRole("USER"));

        return  "admin/home" ;
    }

    //delete User
    @RequestMapping("removeuser/{username}")
    public String removeduser (@PathVariable String username) {

        List<Card> cards = cardServices.findAllbyId(username);

        for(int i=0 ; i<cards.size() ; i++){
            secretKeyServices.deletebyid(cards.get(i).getAccountnumber());
        }

        cardServices.deletebyUserName(username);
        userServices.deletebyUserName(username);
        profileServices.deletebyUserName(username);
        billingServices.deletebyUserName(username);

        return "redirect:/admin/home";
    }

    @RequestMapping("usercarddetail/{username}")
    public String userCardDetail(Model model , @PathVariable String username){

        model.addAttribute("usercards" , cardServices.findAllbyId(username) );

        return  "admin/usercarddetail" ;
    }

}
