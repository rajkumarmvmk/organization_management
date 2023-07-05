package com.example.siliconvalley_prvtd_lmtd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.transform.sax.SAXResult;
@Setter
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
@Table(name="admin")
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String LastName;
    private String email;
    @Column(length = 60)
    private String password;
    private String role;
    private boolean enabled=false;
}
