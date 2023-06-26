package com.example.siliconvalley_prvtd_lmtd.entity;

import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
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
public class ProjectsEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2" )
    private String id;

    @Column(length = 10,nullable = false)
    private Long projectId;

    @Column(length = 30,nullable = false)
    private String projectTitle;

    @Column(length = 30,nullable = false)
    private String organizationName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;  //enum

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private OrganizationEntity organizationEntity;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private SubOrganizationEntity subOrganizationEntity;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private ClientEntity clientEntity;






}
