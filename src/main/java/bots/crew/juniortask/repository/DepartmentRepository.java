package bots.crew.juniortask.repository;

import bots.crew.juniortask.entity.Department;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("from Department d JOIN FETCH d.lectors")
    List<Department> findAll();
}
