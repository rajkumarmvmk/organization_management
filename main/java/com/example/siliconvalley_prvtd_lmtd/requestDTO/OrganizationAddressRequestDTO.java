package com.example.siliconvalley_prvtd_lmtd.requestDTO;


import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrganizationAddressRequestDTO {
    @NotNull(message = "Name is mandatory")
    private Long organizationId;
    @NotNull(message = "Name is mandatory")
    private Integer doorNo;
    @NotBlank(message = "Name is mandatory")
    private String streetName;
    @NotBlank(message = "Name is mandatory")
    private String city;
    @NotBlank(message = "Name is mandatory")
    private String district;
    @NotBlank(message = "Name is mandatory")
    private String state;
    @NotBlank(message = "Name is mandatory")
    private String country;
    @NotNull(message = "Name is mandatory")
    private Long pinCode;
    @NotNull(message = "Name is mandatory")
    private Long mobileNo;
    @NotBlank(message = "Name is mandatory")
    private String emailId;
}
