package edu.bbte.softeng.brim2122.spring.application.port.out;

import edu.bbte.softeng.brim2122.spring.application.domain.entity.Dumbbell;

import java.util.Collection;
import java.util.Optional;

public interface DumbbellOutputPort {
    Collection<Dumbbell> findAll();

    Optional<Dumbbell> findById(Long id);

    Dumbbell save(Dumbbell entity);

    Dumbbell create(Dumbbell entity);

    void delete(Long id);
}
