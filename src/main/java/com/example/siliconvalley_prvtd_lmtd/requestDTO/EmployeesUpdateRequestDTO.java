package com.example.siliconvalley_prvtd_lmtd.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeesUpdateRequestDTO {

    @NotBlank(message = "Name is mandatory")
    private String employeeName;
    @NotBlank(message = "Name is mandatory")
    private String designation;
}
