package com.example.siliconvalley_prvtd_lmtd.entity;

import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="projects")
public class ProjectsEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2" )
    private String id;

    @Column(length = 10,nullable = false)
    private String projectCode;

    @Column(length = 30,nullable = false)
    private String projectTitle;

    @Enumerated(EnumType.STRING)
    private Status status;

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
