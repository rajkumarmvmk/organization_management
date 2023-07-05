package com.example.siliconvalley_prvtd_lmtd.requestDTO;

import lombok.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeesRequestDTO {
    @NotNull(message = "Name is mandatory")
    private String employeeCode;
    @NotBlank(message = "Name is mandatory")
    private String employeeName;
    @NotBlank(message = "Name is mandatory")
    private String designation;
}
