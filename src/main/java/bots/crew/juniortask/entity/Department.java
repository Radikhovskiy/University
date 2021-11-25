package bots.crew.juniortask.entity;

import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Lector headOfDepartment;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "departments_lectors",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "lector_id"))
    private List<Lector> lectors;

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

    public Lector getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(Lector headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public List<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(List<Lector> lectors) {
        this.lectors = lectors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Department that = (Department) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name)
                && Objects.equals(headOfDepartment, that.headOfDepartment)
                && Objects.equals(lectors, that.lectors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, headOfDepartment, lectors);
    }

    @Override
    public String toString() {
        return "Department{id=" + id
                + ", name='" + name + '\''
                + ", headOfDepartment=" + headOfDepartment
                + ", lectors=" + lectors + '}';
    }
}
