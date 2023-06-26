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
public class EmployeesEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2" )
    private String id;
    @Column(length = 10,nullable = false,unique = true)
    private Long employeeId;

    @Column(length = 30,nullable = false)
    private String employeeName;

    @Column(length = 30,nullable = false)
    private String designation;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private OrganizationEntity organizationEntity;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private SubOrganizationEntity subOrganizationEntity;

}
