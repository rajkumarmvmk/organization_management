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
public class SubOrganizationAddressEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2" )
    private String id;
    @Column(length = 12,nullable = false,unique = true)
    private Long subOrganizationId;
    @Column(length = 4,nullable = false)
    private Integer doorNo;
    @Column(length = 30,nullable = false)
    private String streetName;
    @Column(length = 30,nullable = false)
    private String city;
    @Column(length = 30,nullable = false)
    private String district;
    @Column(length = 30,nullable = false)
    private String state;
    @Column(length = 30,nullable = false)
    private String country;
    @Column(length = 10,nullable = false)
    private Long pinCode;
    @Column(length = 12,nullable = false)
    private Long contact;
    @Column(length = 50,nullable = false,unique = true)
    private String emailId;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private SubOrganizationEntity subOrganizationEntity;
}
