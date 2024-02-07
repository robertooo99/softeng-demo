package edu.bbte.softeng.brim2122.spring.application.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Dumbbell extends BaseEntity{
    String description;
    String dtype;
    Integer weight;
    Integer price;
    Integer quantity;
}
