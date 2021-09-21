package com.example.crm.backend.repository;

import com.example.crm.backend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author satya
 */
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
