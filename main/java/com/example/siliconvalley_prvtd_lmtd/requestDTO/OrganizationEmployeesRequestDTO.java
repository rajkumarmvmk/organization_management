package com.example.siliconvalley_prvtd_lmtd.requestDTO;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrganizationEmployeesRequestDTO {
    @NotNull(message = "Name is mandatory")
    private Long employeeId;
    @NotBlank(message = "Name is mandatory")
    private String employeeName;
    @NotBlank(message = "Name is mandatory")
    private String employeeRole;
    @NotBlank(message = "Name is mandatory")
    private String domain;
    @NotBlank(message = "Name is mandatory")
    private String bloodGroup;


}
