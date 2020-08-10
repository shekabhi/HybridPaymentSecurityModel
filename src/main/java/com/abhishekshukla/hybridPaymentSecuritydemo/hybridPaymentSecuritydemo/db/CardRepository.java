package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.db;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card , Long> {

    @Query(value = " select * from card where username = :name "  ,  nativeQuery = true)
    List<Card> findAllById(String name);

    @Query(value = " select * from card where id = :id "  ,  nativeQuery = true)
    Card findById(long id);

    @Modifying
    @Transactional
    @Query(value = " delete from card where username = :username "  ,  nativeQuery = true)
    void deletebyUserName(String username);
}
