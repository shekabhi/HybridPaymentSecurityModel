package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.db;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.EncodedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecretKeyInfoRepository extends JpaRepository<EncodedData , String> {

    @Query(value = " select * from secretinfo where accountnumber = :accountnumber "  ,  nativeQuery = true)
    List<EncodedData> findByIdd(String accountnumber);
}
