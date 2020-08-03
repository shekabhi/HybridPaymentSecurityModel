package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.controller;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.Card;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.EncodedData;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services.CardServices;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services.SecretKeyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;



@Controller
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private CardServices cardServices;

    @Autowired
    private SecretKeyServices secretKeyServices;

    static Cipher cipher ;


    @GetMapping("mainhome")
    public String mainHomePage(){
        return "home";
    }

    @GetMapping("home")
    public String index(Model model, Principal principal) throws Exception {


        List<Card> list = cardServices.findAllbyId(principal.getName());
       // System.out.println("SIZE OF LIST : " + list.size());
        List<Card> newlist = new  ArrayList<Card>();

        for(int i=0 ; i<list.size() ; i++){
            Card card = new Card() ;
            Card newcard = new Card() ;

            card = list.get(i);
            //System.out.println("Acount number : " + card.getAccountnumber());
            //System.out.println(secretKeyServices.findbyid(card.getAccountnumber()).size());

            String sk = secretKeyServices.findbyid(card.getAccountnumber()).get(0).getSecretKey();

            byte[] decodedKey = Base64.getDecoder().decode(sk);
            SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
            //System.out.println(originalKey);

            newcard.setAccountnumber(decrypt(card.getAccountnumber() , originalKey));
            newcard.setFirstname(decrypt(card.getFirstname() , originalKey));
            newcard.setLastname(decrypt(card.getLastname(),originalKey));
            newcard.setExpdate(decrypt(card.getExpdate(),originalKey));


            //newcard.setAccountnumber(decrypt(card.getAccountnumber() , ## ));

            newlist.add(newcard);
        }

        model.addAttribute("cards" , newlist);
      // System.out.println("User Card : " + cardServices.findAllbyId(principal.getName()));
        return "payment/home";
    }

    @GetMapping("onetimepay")
    public String onetimepay(){
        return "payment/onetimepay";
    }

    @GetMapping("addcard")
    public String addcard(){
        return "payment/addcard";
    }

    @PostMapping("newcardadded")
    public String newcardadded(@RequestParam("accountnumber") String accountnumber,
                             @RequestParam("firstname") String firstname,
                               @RequestParam("lastname") String lastname,
                             @RequestParam("expdate") String expdate,
                             Principal principal) throws Exception {

        //Encryption and Decryption Algorithm

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // block size is 128bits
        SecretKey secretKey = keyGenerator.generateKey();
        //System.out.println("My secret Key before " + secretKey);

        //Encoding SecretKey

        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        //System.out.println("My encoded secret Key " + encodedKey);


        // Decoding SecretKey

        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

        //System.out.println("My decoded secret Key  " + originalKey);

        cipher = Cipher.getInstance("AES");


        // Adding new Card
        EncodedData encodedData = new EncodedData();

        encodedData.setAccountnumber(encrypt(accountnumber,secretKey));
        encodedData.setSecretKey(encodedKey);

        secretKeyServices.secretkeyinfo(encodedData);

        Card card = new Card() ;

        card.setAccountnumber(encrypt(accountnumber,secretKey));
        card.setUsername(principal.getName());
        card.setFirstname(encrypt(firstname , secretKey));
        card.setLastname(encrypt(lastname , secretKey));
        card.setExpdate(encrypt(expdate , secretKey));

        cardServices.insertCard(card);
       // System.out.println(" Card Detail : " + card);

        return "redirect:/payment/home";
    }

    //delete Card
//    @RequestMapping("removecard/{id}")
//    public String removedcard (@PathVariable String id) {
//        System.out.println("Remove ID is : " + id);
//        cardServices.deletebyid(id);
//        return "redirect:/payment/home";
//    }

    @RequestMapping("paymentgateway")
    public String paymentGateway(){
        return "payment/paymentgateway";
    }

    // Logic

    public static String encrypt(String plainText, SecretKey secretKey)
            throws Exception {
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
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
