package com.example.crm.service;

import com.example.crm.entity.Company;
import com.example.crm.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author satya
 */
@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

}
