package edu.bbte.softeng.brim2122.spring.adapter.out.persistence;

import edu.bbte.softeng.brim2122.spring.application.domain.entity.Dumbbell;
import edu.bbte.softeng.brim2122.spring.application.port.out.DumbbellOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class DumbbellJpaAdapter implements DumbbellOutputPort {
    @Autowired
    private DumbbellRepository dumbbellRepository;

    @Autowired
    private DumbbellJpaMapper dumbbellJpaMapper;
    @Override
    public Collection<Dumbbell> findAll() {
        return dumbbellJpaMapper.jpasToModels(dumbbellRepository.findAll());
    }

    @Override
    public Optional<Dumbbell> findById(Long id) {
        Optional<DumbbellJpaEntity> dumbbellJpaEntity = dumbbellRepository.findById(id);
        return dumbbellJpaEntity.map(dumbbellJpaMapper::jpaToModel);
    }

    @Override
    public Dumbbell save(Dumbbell entity) {
        return dumbbellJpaMapper.jpaToModel(dumbbellRepository.save(dumbbellJpaMapper.modelToJpa(entity)));
    }

    @Override
    public Dumbbell create(Dumbbell entity) {
        return dumbbellJpaMapper.jpaToModel(dumbbellRepository.save(dumbbellJpaMapper.modelToJpa(entity)));
    }

    @Override
    public void delete(Long id) {
        dumbbellRepository.deleteById(id);
    }
}
