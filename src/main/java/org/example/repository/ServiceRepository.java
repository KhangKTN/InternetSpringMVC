package org.example.repository;

import org.example.domain.ServiceDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceDomain, Long> {
}
