package bots.crew.juniortask;

import bots.crew.juniortask.entity.Degree;
import bots.crew.juniortask.entity.Department;
import bots.crew.juniortask.entity.Lector;
import bots.crew.juniortask.service.DepartmentService;
import bots.crew.juniortask.service.LectorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initializer {
    private LectorService lectorService;
    private DepartmentService departmentService;

    @Autowired
    public Initializer(LectorService lectorService, DepartmentService departmentService) {
        this.lectorService = lectorService;
        this.departmentService = departmentService;
    }

    public Initializer() {
    }

    public void initialize() {
        Department historyOfArt = new Department();
        historyOfArt.setName("History of art");

        Department archaeology = new Department();
        archaeology.setName("Archaeology");

        Department psychology = new Department();
        psychology.setName("Psychology");

        Lector roman = new Lector();
        roman.setName("Roman");
        roman.setLastName("Ivanovich");
        roman.setDegree(Degree.PROFESSOR);
        roman.setDepartments(List.of(psychology));
        roman.setSalary(500);

        Lector taras = new Lector();
        taras.setName("Taras");
        taras.setLastName("Stepatovich");
        taras.setDegree(Degree.PROFESSOR);
        taras.setDepartments(List.of(historyOfArt));
        taras.setSalary(600);

        Lector petro = new Lector();
        petro.setName("Petro");
        petro.setLastName("Lastochkin");
        petro.setDegree(Degree.ASSISTANT);
        petro.setDepartments(List.of(archaeology, historyOfArt));
        petro.setSalary(300);

        Lector ivan = new Lector();
        ivan.setName("Ivan");
        ivan.setLastName("Kosuta");
        ivan.setDegree(Degree.PROFESSOR);
        ivan.setDepartments(List.of(archaeology));
        ivan.setSalary(500);

        Lector ostap = new Lector();
        ostap.setName("Ostap");
        ostap.setLastName("Livak");
        ostap.setDegree(Degree.ASSOCIATE_PROFESSOR);
        ostap.setDepartments(List.of(historyOfArt, psychology, archaeology));
        ostap.setSalary(400);

        lectorService.add(roman);
        lectorService.add(taras);
        lectorService.add(petro);
        lectorService.add(ivan);
        lectorService.add(ostap);

        historyOfArt.setHeadOfDepartment(taras);
        historyOfArt.setLectors(List.of(ostap, petro, taras));

        archaeology.setHeadOfDepartment(ivan);
        archaeology.setLectors(List.of(ivan, ostap, petro));

        psychology.setHeadOfDepartment(roman);
        psychology.setLectors(List.of(roman, ostap));

        departmentService.add(historyOfArt);
        departmentService.add(archaeology);
        departmentService.add(psychology);
    }
}
