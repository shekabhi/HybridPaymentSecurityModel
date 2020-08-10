package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.db;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BillingRepository  extends JpaRepository<Billing, Long> {

    @Query(value = " select * from billing where username = :username "  ,  nativeQuery = true)
    List<Billing> findAllById(String username);

    @Modifying
    @Transactional
    @Query(value = " delete from billing where username = :username "  ,  nativeQuery = true)
    void deletebyUserName(String username);
}
