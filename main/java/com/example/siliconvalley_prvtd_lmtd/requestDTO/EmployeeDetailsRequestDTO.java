package com.example.siliconvalley_prvtd_lmtd.requestDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDetailsRequestDTO {
    @NotNull(message = "Name is mandatory")
    private String id;
    @NotNull(message = "Name is mandatory")
    private Long employeeCode;
    @NotBlank(message = "Name is mandatory")
    private String employeeName;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dateOfBirth;
    @NotNull(message = "Name is mandatory")
    private Integer experience;
    @NotBlank(message = "Name is mandatory")
    private String qualification;

    private String fatherName;

    private String motherName;

}
