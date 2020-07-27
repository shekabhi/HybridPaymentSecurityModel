package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.db;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String user);
}
