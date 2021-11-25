package bots.crew.juniortask.service;

import bots.crew.juniortask.entity.Department;
import bots.crew.juniortask.entity.Lector;
import bots.crew.juniortask.repository.DepartmentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Department add(Department department) {
        return repository.save(department);
    }

    @Override
    public List<Department> getAll() {
        return repository.findAll();
    }

    @Override
    public Department getByName(String name) {
        for (Department department : getAll()) {
            if (department.getName().equalsIgnoreCase(name)) {
                return department;
            }
        }
        return null;
    }

    @Override
    public List<Lector> getAllLectorsFromDepartment(Department department) {
        return department.getLectors();
    }

    @Override
    public String getCountOfEmployee(Department department) {
        return String.valueOf(getAllLectorsFromDepartment(department).size());
    }

    @Override
    public String getAverageSalary(Department department) {
        return "The average salary of " + department.getName()
                + " is " + (department.getLectors().stream()
                .mapToInt(Lector::getSalary).sum()) / department.getLectors().size();
    }

    @Override
    public String getHeadOfDepartment(Department department) {
        if (department.getHeadOfDepartment() != null) {
            return "Head of " + department.getName()
                    + " department is " + department.getHeadOfDepartment().getName()
                    + " " + department.getHeadOfDepartment().getLastName();
        } else {
            return "No head of department";
        }
    }

    @Override
    public String getStatistic(Department department) {
        int countOfAssistant = 0;
        int countOfAssociateProfessor = 0;
        int countOfProfessor = 0;
        for (Lector lector: department.getLectors()) {
            switch (lector.getDegree()) {
                case ASSISTANT: countOfAssistant++;
                break;
                case ASSOCIATE_PROFESSOR: countOfAssociateProfessor++;
                break;
                default: countOfProfessor++;
                break;
            }
        }
        return "Statistic for " + department.getName() + " department: \n"
                + "Assistants - " + countOfAssistant + "\n"
                + "Associate professors - " + countOfProfessor + "\n"
                + "Professors - " + countOfAssociateProfessor;
    }
}
