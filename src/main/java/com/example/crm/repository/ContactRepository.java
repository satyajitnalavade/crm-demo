package com.example.crm.repository;

import com.example.crm.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author satya
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
