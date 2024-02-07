package edu.bbte.softeng.brim2122.spring.application.port.in;

import edu.bbte.softeng.brim2122.spring.application.domain.entity.Dumbbell;

import java.util.Collection;

public interface DumbbellInputPort {
    Dumbbell addNewDumbbell(Dumbbell dumbbell);

    Dumbbell buyDumbbell(Long dumbbellId, Integer amount);

    Dumbbell increaseDumbbellQuantity(Long dumbbellId);

    Collection<Dumbbell> getAllDumbbells();

    void deleteDumbbell(Long dumbbellId);
}
