package edu.bbte.softeng.brim2122.spring.adapter.out.persistence;

import edu.bbte.softeng.brim2122.spring.application.domain.entity.Dumbbell;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class DumbbellJpaMapper {
    @IterableMapping(elementTargetType = DumbbellJpaEntity.class)
    public abstract Collection<DumbbellJpaEntity> modelsToJpas(Iterable<Dumbbell> model);

    public abstract DumbbellJpaEntity modelToJpa(Dumbbell model);

    @IterableMapping(elementTargetType = Dumbbell.class)
    public abstract Collection<Dumbbell> jpasToModels(Iterable<DumbbellJpaEntity> jpa);

    public abstract Dumbbell jpaToModel(DumbbellJpaEntity dumbbellJpaEntity);
}
