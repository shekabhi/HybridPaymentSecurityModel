package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.db.CardRepository;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Transactional
@Service
public class CardServicesImpl implements CardServices {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public void insertCard(Card card) {
        cardRepository.save(card);
    }

    @Override
    public List<Card> findAllbyId(String name) {
        return cardRepository.findAllById(name);
    }

    @Override
    public void deletebyid(int id) {
        cardRepository.deleteById((long) id);
    }

    @Override
    public Card findbyId(int id) {
        return cardRepository.findById((long)id) ;
    }

    @Override
    public void deletebyUserName(String username) {
        cardRepository.deletebyUserName(username); ;
    }

}
