package com.service.demo.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDate;;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "employee", schema = "public")
public class EmployeeEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "salary")
    private Long salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;

    @Column(name = "position_id")
    private Long positionId;

    @Column(name = "office_id")
    private Long officeId;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private EmployeeEntity director;

    @OneToMany(mappedBy = "director")
    private List<EmployeeEntity> subordinates;

    public EmployeeEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeEntity)) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(name, that.name) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(age, that.age) &&
            Objects.equals(birthdate, that.birthdate) &&
            Objects.equals(salary, that.salary) &&
            Objects.equals(department, that.department) &&
            Objects.equals(positionId, that.positionId) &&
            Objects.equals(director, that.director) &&
            Objects.equals(subordinates, that.subordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name,
            lastName, age, birthdate, salary,
            department, positionId, director, subordinates);
    }
}
