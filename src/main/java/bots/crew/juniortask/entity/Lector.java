package bots.crew.juniortask.entity;

import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lectors")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "lectors")
    private List<Department> departments;
    @Enumerated(value = EnumType.STRING)
    private Degree degree;
    private int salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lector lector = (Lector) o;
        return salary == lector.salary && Objects.equals(id, lector.id)
                && Objects.equals(name, lector.name) && Objects.equals(lastName, lector.lastName)
                && Objects.equals(departments, lector.departments) && degree == lector.degree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, departments, degree, salary);
    }

    @Override
    public String toString() {
        return "Lector{name='" + name + '\''
                + ", lastname='" + lastName + '}';
    }
}
