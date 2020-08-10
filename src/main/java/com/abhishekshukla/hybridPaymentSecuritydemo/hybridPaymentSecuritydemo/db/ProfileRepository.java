package com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.db;

import com.abhishekshukla.hybridPaymentSecuritydemo.hybridPaymentSecuritydemo.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {

    @Query(value = " select * from profile where username = :name "  ,  nativeQuery = true)
    Profile findbyUser(String name);

    @Modifying(clearAutomatically = true)
    @Query(value = " update profile set name = :name , email = :email , number = :number , location = :location where username = :username"  ,  nativeQuery = true)
    void upadateProfile(String username ,String name, String email, String number, String location);

    @Modifying(clearAutomatically = true)
    @Query(value = " update user set passward = :encodedPassword where username = :name"  ,  nativeQuery = true)
    void updatePassword(String name, String encodedPassword);

}
