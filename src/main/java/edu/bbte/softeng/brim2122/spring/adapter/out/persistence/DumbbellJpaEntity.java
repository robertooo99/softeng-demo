package edu.bbte.softeng.brim2122.spring.adapter.out.persistence;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Dumbbell")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DumbbellJpaEntity {
    @Id
    @GeneratedValue
    Long id;

    @Column(length = 256)
    String description;

    @Column(unique = true, length = 20)
    String dtype;

    @Column
    Integer weight;

    @Column
    Integer price;

    @Column
    Integer quantity;
}
