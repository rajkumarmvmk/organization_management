package com.example.siliconvalley_prvtd_lmtd.requestDTO;

import lombok.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrganizationEmployeesRequestDTO {
    @NotNull(message = "Name is mandatory")
    private Long employeeCode;
    @NotBlank(message = "Name is mandatory")
    private String employeeName;
    @NotBlank(message = "Name is mandatory")
    private String employeeRole;
    @NotBlank(message = "Name is mandatory")
    private String domain;
    @NotBlank(message = "Name is mandatory")
    private String bloodGroup;


}
