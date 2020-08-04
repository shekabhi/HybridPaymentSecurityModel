package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.db;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card , Long> {

    @Query(value = " select * from card where username = :name "  ,  nativeQuery = true)
    List<Card> findAllById(String name);

    @Query(value = " select * from card where id = :id "  ,  nativeQuery = true)
    Card findById(long id);
}
