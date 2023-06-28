package com.example.siliconvalley_prvtd_lmtd.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name="employee_personal_details")
public class EmployeePersonalDetailsEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2" )
    private String id;
    @Column(length = 10,nullable = false,unique = true)
    private String employeeCode;
    @Column(length = 30,nullable = false)
    private String employeeName;
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @Column(length = 2)
    private Integer experience;
    @Column(length = 20,nullable = false)
    private String qualification;
    @Column(length = 30)
    private String fatherName;
    @Column(length = 30)
    private String motherName;
    @Column(length = 5,nullable = false)
    private String bloodGroup;
    @Column(length = 12,nullable = false)
    private Long mobileNo;
    @Column(length=30,nullable = false,unique = true)
    private String emailId;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private EmployeesEntity employeesEntity;

}
