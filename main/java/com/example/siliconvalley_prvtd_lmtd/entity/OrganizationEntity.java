package com.example.siliconvalley_prvtd_lmtd.entity;

import com.example.siliconvalley_prvtd_lmtd.enumBox.CompanyType;
import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class OrganizationEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2" )
    private String id;

    @Column(length = 12,nullable = false,unique = true)
    private String organizationId;

    @Column(length = 50,nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String timezone;

    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    @Column(nullable = false)
    private String industry;
 

}
