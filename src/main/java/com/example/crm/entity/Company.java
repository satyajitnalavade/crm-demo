package com.example.crm.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

/**
 * @author satya
 */
@Entity
public class Company extends AbstractEntity implements Cloneable{

    private String name;

    @OneToMany(fetch = javax.persistence.FetchType.EAGER, mappedBy = "company")
    private List<Contact> employees = new LinkedList<>();

    public Company(String name) {
        this.name = name;
    }

    public Company() {
    }

    public List<Contact> getEmployees() {
        return employees;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}