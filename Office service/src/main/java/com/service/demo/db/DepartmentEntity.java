package com.service.demo.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "department", schema = "public")
public class DepartmentEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_dep")
    private String nameDepartment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepartmentEntity)) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return Objects.equals(id, that.id)
            && Objects.equals(nameDepartment, that.nameDepartment);
    }
}
