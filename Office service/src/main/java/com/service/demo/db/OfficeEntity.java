package com.service.demo.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "office", schema = "public")
public class OfficeEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_office")
    private Long numberOffice;

    @Column(name = "capacity")
    private Long capacity;

    @Column(name = "current_workload")
    private Long currentWorkload;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OfficeEntity)) return false;
        OfficeEntity that = (OfficeEntity) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(numberOffice, that.numberOffice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOffice);
    }
}
