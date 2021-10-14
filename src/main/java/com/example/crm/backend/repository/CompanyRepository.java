package com.example.crm.backend.repository;

import com.example.crm.backend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author satya
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
