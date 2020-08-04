package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.db.SecretKeyInfoRepository;
import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.EncodedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class SecretKeyServicesImpl implements SecretKeyServices {

    @Autowired
    private SecretKeyInfoRepository secretKeyInfoRepository;

    @Override
    public void secretkeyinfo(EncodedData encodedData) {
        secretKeyInfoRepository.save(encodedData);
    }

    @Override
    public List<EncodedData> findbyid(String accountnumber) {
        return secretKeyInfoRepository.findByIdd(accountnumber);
    }

    @Override
    public void deletebyid(String accountnumber) {
         secretKeyInfoRepository.deleteById(accountnumber);  ;
    }


}
