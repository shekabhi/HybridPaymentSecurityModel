package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.Card;

import java.util.List;

public interface CardServices {
    public void insertCard(Card card);

    public List<Card> findAllbyId(String name);

    public  void deletebyid(int id);

    public Card findbyId(int id);
}
