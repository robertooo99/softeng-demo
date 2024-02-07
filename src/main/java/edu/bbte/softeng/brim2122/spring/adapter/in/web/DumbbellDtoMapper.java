package edu.bbte.softeng.brim2122.spring.adapter.in.web;

import edu.bbte.softeng.brim2122.spring.adapter.in.web.dto.incoming.DumbbellCreationDto;
import edu.bbte.softeng.brim2122.spring.application.domain.entity.Dumbbell;
import edu.bbte.softeng.brim2122.spring.adapter.in.web.dto.outgoing.DumbbellDetailsDto;
import edu.bbte.softeng.brim2122.spring.adapter.in.web.dto.outgoing.DumbbellReducedDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class DumbbellDtoMapper {
    @IterableMapping(elementTargetType = DumbbellReducedDto.class)
    public abstract Collection<DumbbellReducedDto> modelsToReducedDtos(Iterable<Dumbbell> model);

    public abstract DumbbellDetailsDto modelToDetailsDto(Dumbbell model);

    public abstract Dumbbell creationDtoToModel(DumbbellCreationDto creationDto);
}
