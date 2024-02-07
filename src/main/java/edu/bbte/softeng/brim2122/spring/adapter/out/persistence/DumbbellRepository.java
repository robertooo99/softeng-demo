package edu.bbte.softeng.brim2122.spring.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DumbbellRepository extends JpaRepository<DumbbellJpaEntity, Long> {
}
