package edu.bbte.softeng.brim2122.spring.application.domain.service;

import edu.bbte.softeng.brim2122.spring.application.domain.entity.Dumbbell;
import edu.bbte.softeng.brim2122.spring.application.port.in.DumbbellInputPort;
import edu.bbte.softeng.brim2122.spring.application.port.out.DumbbellOutputPort;
import edu.bbte.softeng.brim2122.spring.exception.ServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DumbbellService implements DumbbellInputPort {
    private DumbbellOutputPort dumbbellOutputPort;

    @Override
    public Dumbbell addNewDumbbell(Dumbbell dumbbell) {
        return dumbbellOutputPort.create(dumbbell);
    }

    @Override
    public Dumbbell buyDumbbell(Long dumbbellId, Integer amount) {
        Optional<Dumbbell> dumbbellOptional = dumbbellOutputPort.findById(dumbbellId);
        if (dumbbellOptional.isEmpty()) {
            throw new ServiceException("No dumbbell was found to buy, with the provided ID");
        }
        if (amount <= 0) {
            throw new ServiceException("You can't buy a negative amount of dumbbells");
        }
        Dumbbell dumbbell = dumbbellOptional.get();
        dumbbell.setQuantity(dumbbell.getQuantity() - amount);
        dumbbellOutputPort.save(dumbbell);
        return dumbbell;
    }

    @Override
    public Dumbbell increaseDumbbellQuantity(Long dumbbellId) {
        Optional<Dumbbell> dumbbellOptional = dumbbellOutputPort.findById(dumbbellId);
        if (dumbbellOptional.isEmpty()) {
            throw new ServiceException("No dumbbell was found, with the provided ID");
        }
        Dumbbell dumbbell = dumbbellOptional.get();
        dumbbell.setQuantity(dumbbell.getQuantity() + 1);
        dumbbellOutputPort.save(dumbbell);
        return dumbbell;
    }

    @Override
    public Collection<Dumbbell> getAllDumbbells() {
        Collection<Dumbbell> dumbbells = dumbbellOutputPort.findAll();
        if (dumbbells.isEmpty()) {
            throw new ServiceException("No dumbbells were found!");
        }
        return dumbbells;
    }

    @Override
    public void deleteDumbbell(Long dumbbellId) {
        Optional<Dumbbell> dumbbell = dumbbellOutputPort.findById(dumbbellId);
        if (dumbbell.isEmpty()) {
            throw new ServiceException("No dumbbell was found to delete, with the provided ID");
        }
        dumbbellOutputPort.delete(dumbbellId);
    }
}
