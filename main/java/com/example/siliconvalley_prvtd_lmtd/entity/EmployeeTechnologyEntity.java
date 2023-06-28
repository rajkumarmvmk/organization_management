package com.example.siliconvalley_prvtd_lmtd.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name="employee_technology")
public class EmployeeTechnologyEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2" )
    private String id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private EmployeesEntity employeesEntity;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private TechnologyEntity technologyEntity;
}
