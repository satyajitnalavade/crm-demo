package com.example.crm.backend.entity;

import org.hibernate.Hibernate;


import javax.persistence.*;
import java.util.Objects;

/**
 * @author satya
 */
@MappedSuperclass
public class AbstractEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public boolean isPersisted() {
        return id != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        AbstractEntity that = (AbstractEntity) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 2076924755;
    }
}
