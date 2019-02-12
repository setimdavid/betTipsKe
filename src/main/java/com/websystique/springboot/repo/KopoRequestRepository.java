package com.websystique.springboot.repo;

import com.websystique.springboot.model.KopoRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KopoRequestRepository extends JpaRepository<KopoRequest,Integer> {
}
