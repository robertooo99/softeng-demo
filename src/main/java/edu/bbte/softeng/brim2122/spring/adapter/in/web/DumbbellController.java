package edu.bbte.softeng.brim2122.spring.adapter.in.web;

import edu.bbte.softeng.brim2122.spring.adapter.in.web.dto.incoming.DumbbellCreationDto;
import edu.bbte.softeng.brim2122.spring.adapter.in.web.dto.outgoing.DumbbellReducedDto;
import edu.bbte.softeng.brim2122.spring.application.domain.entity.Dumbbell;
import edu.bbte.softeng.brim2122.spring.exception.BadRequestException;
import edu.bbte.softeng.brim2122.spring.exception.NotFoundException;
import edu.bbte.softeng.brim2122.spring.application.port.in.DumbbellInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/dumbbells")
public class DumbbellController {
    @Autowired
    DumbbellDtoMapper dumbbellDtoMapper;

    @Autowired
    DumbbellInputPort dumbbellInputPort;

    @GetMapping
    public Collection<DumbbellReducedDto> findAllDumbbells() {
        Collection<Dumbbell> dumbbells = dumbbellInputPort.getAllDumbbells();
        if (dumbbells.isEmpty()) {
            throw new NotFoundException("No dumbbells were found!");
        }
        return dumbbellDtoMapper.modelsToReducedDtos(dumbbells);
    }

    @PostMapping
    public Dumbbell createDumbbell(@RequestBody @Valid DumbbellCreationDto dumbbellDto) {
        return dumbbellInputPort.addNewDumbbell(dumbbellDtoMapper.creationDtoToModel(dumbbellDto));
    }

    @PatchMapping("/{dumbbellId}")
    public Dumbbell updateDumbbell(@PathVariable("dumbbellId") Long dumbbellId, @RequestParam(value = "amount", required = false) Integer amount) {
        if (dumbbellId <= 0) {
            throw new BadRequestException("The provided ID is not good!");
        }
        if (amount == null) {
            return dumbbellInputPort.increaseDumbbellQuantity(dumbbellId);
        }
        return dumbbellInputPort.buyDumbbell(dumbbellId, amount);
    }

    @DeleteMapping("/{dumbbellId}")
    public void deleteDumbbell(@PathVariable("dumbbellId") Long dumbbellId) {
        if (dumbbellId <= 0) {
            throw new BadRequestException("The provided ID is not good!");
        }
        dumbbellInputPort.deleteDumbbell(dumbbellId);
    }
}
