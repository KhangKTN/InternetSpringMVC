package org.example.repository;

import org.example.domain.ServiceDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<ServiceDomain, Long> {
    List<ServiceDomain> findByNameContaining(String name);
    Page<ServiceDomain> findByNameContaining(Pageable pageable, String name);
    ServiceDomain findById(String id);
}
