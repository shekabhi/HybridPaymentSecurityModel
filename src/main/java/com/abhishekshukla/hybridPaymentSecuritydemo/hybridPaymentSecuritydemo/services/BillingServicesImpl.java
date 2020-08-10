package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.db.BillingRepository;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.Billing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class BillingServicesImpl implements BillingServices {

    @Autowired
    private BillingRepository billingRepository ;

    @Override
    public List<Billing> findAllbyId(String username) {
        return billingRepository.findAllById(username);
    }


    @Override
    public void insertBillLog(Billing billing) {
        billingRepository.save(billing);
    }

    @Override
    public void deletebyUserName(String username) {
        billingRepository.deletebyUserName(username); ;
    }
}
