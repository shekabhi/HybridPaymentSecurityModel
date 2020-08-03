package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.services;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.EncodedData;

import java.util.List;
import java.util.Optional;

public interface SecretKeyServices {

    public void secretkeyinfo(EncodedData encodedData);

    public List<EncodedData> findbyid(String accountnumber);
}
