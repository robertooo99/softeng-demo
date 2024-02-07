package edu.bbte.softeng.brim2122.spring.application.domain.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    Long id;
}
