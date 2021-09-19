package com.example.crm.repository;

import com.example.crm.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author satya
 */
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
