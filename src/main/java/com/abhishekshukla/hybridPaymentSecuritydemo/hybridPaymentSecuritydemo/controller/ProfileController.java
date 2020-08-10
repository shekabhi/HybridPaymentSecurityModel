package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.controller;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.Billing;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.Card;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.Profile;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    private UserServices userServices ;

    @Autowired
    private CardServices cardServices;

    @Autowired
    private SecretKeyServices secretKeyServices;

    @Autowired
    private ProfileServices profileServices;

    @Autowired
    private BillingServices billingServices;

    static Cipher cipher ;

    @RequestMapping("home")
    public String profilePage(Model model , Principal principal){

        model.addAttribute("profiles" , profileServices.findbyuser(principal.getName()));

        return "profile/home" ;
    }

    @RequestMapping("accountsecurity")
    public String accountSecurity(){
        return "profile/accountsecurity" ;
    }

    @RequestMapping("deleteaccount")
    public String deleteAccount(Principal principal){

        String username = principal.getName();

        List<Card> cards = cardServices.findAllbyId(username);

        for(int i=0 ; i<cards.size() ; i++){
            secretKeyServices.deletebyid(cards.get(i).getAccountnumber());
        }

        cardServices.deletebyUserName(username);
        userServices.deletebyUserName(username);
        profileServices.deletebyUserName(username);
        billingServices.deletebyUserName(username);


        return "/login" ;
    }

    @RequestMapping("updateprofile")
    public String updateProfile(@RequestParam("name") String name, @RequestParam("email") String email,
                                @RequestParam("number") String number,@RequestParam("location") String location,
                                Principal principal){

        Profile profile = new Profile();
        profile.setUsername(principal.getName());
        profile.setName(name);
        profile.setEmail(email);
        profile.setNumber(number);
        profile.setLocation(location);

       // System.out.println(profile);

        profileServices.updateProfile(principal.getName() ,name , email , number , location);

        return "redirect:/profile/home";
    }

    @RequestMapping("updatepassword")
    public String updatePassword(@RequestParam("password") String password , Principal principal ) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        String encodedPassword = passwordEncoder.encode(password);
        System.out.println(encodedPassword);

        profileServices.updatePassword(principal.getName() , encodedPassword);

        String message = "Password Updated" ;


        return "redirect:/profile/accountsecurity";
    }

    @RequestMapping("billing")
    public String billingLogs(Model model , Principal principal) throws Exception {

        String username = principal.getName();

        List<Billing> list= billingServices.findAllbyId(username);
       // System.out.println(list);

        List<Billing> newlist = new ArrayList<Billing>();

        for(int i=0 ; i<list.size() ; i++){
            Billing billing = new Billing();
            Billing newbilling = new Billing();

            billing = list.get(i);

            String sk = secretKeyServices.findbyid(billing.getAccountnumber()).get(0).getSecretKey();

            byte[] decodedKey = Base64.getDecoder().decode(sk);
            SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
            //System.out.println(originalKey);

            newbilling.setUsername(billing.getUsername());
            newbilling.setAccountnumber(decrypt(billing.getAccountnumber() , originalKey));
            newbilling.setTime(billing.getTime());

            newlist.add(newbilling);
        }
        //System.out.println(newlist);
        model.addAttribute("billings" , newlist);

        return "profile/billing" ;
    }

    public static String decrypt(String encryptedText, SecretKey secretKey)
            throws Exception {
        cipher = Cipher.getInstance("AES");
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }
}
