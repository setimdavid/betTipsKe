package com.websystique.springboot.repo;

import com.websystique.springboot.model.SubscriberDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriberDetailsRepository extends JpaRepository<SubscriberDetails,Integer> {
   Optional<SubscriberDetails> findSubscriberDetailsByPhoneNumber(String phoneNumber);
   Optional<SubscriberDetails> findSubscriberDetailById(String id);
}
