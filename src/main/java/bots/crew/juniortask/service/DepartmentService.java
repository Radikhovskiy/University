package bots.crew.juniortask.service;

import bots.crew.juniortask.entity.Department;
import bots.crew.juniortask.entity.Lector;
import java.util.List;

public interface DepartmentService {
    Department add(Department department);

    Department getByName(String name);

    List<Lector> getAllLectorsFromDepartment(Department department);

    String getCountOfEmployee(Department department);

    String getHeadOfDepartment(Department department);

    String getStatistic(Department department);

    String getAverageSalary(Department department);

    List<Department> getAll();
}
