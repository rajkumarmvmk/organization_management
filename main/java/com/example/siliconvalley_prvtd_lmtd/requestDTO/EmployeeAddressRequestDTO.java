package com.example.siliconvalley_prvtd_lmtd.requestDTO;

import lombok.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeAddressRequestDTO {
    @NotNull(message = "EmployeeId is mandatory")
    private Long employeeId;

    @NotNull(message = "DoorNo is mandatory")
    private Integer doorNo;

    @NotBlank(message = "StreetNo is mandatory")
    private String streetName;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "District is mandatory")
    private String district;

    @NotBlank(message = "State is mandatory")
    private String state;

    @NotBlank(message = "Name is mandatory")
    private String country;

    @NotNull(message = " is mandatory")
    private Long pinCode;

    @NotNull(message = "Name is mandatory")
    private Long mobileNo;

    @NotBlank(message = "Name is mandatory")
    private String emailId;


}
