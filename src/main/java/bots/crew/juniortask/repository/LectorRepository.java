package bots.crew.juniortask.repository;

import bots.crew.juniortask.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
}
