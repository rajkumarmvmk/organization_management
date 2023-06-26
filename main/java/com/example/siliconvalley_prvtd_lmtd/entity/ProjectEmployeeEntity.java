package com.example.siliconvalley_prvtd_lmtd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProjectEmployeeEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2" )
    private String id;

    @ManyToOne
    private EmployeesEntity employeesEntity;

    @ManyToOne
    private ProjectsEntity projectsEntity;
    private LocalDate startDate;
    private LocalDate endDate;
}
