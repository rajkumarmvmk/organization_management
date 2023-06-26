package com.example.siliconvalley_prvtd_lmtd.requestDTO;

import com.example.siliconvalley_prvtd_lmtd.enumBox.CompanyType;
import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrganizationRequestDTO {

    @NotNull(message = "Id is mandatory")
    private String organizationId;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message="Status define is mandatory")
    private Status  status;
    @NotBlank(message = "Country is mandatory")
    private String country;
    @NotBlank(message = "timeZone is mandatory")
    private String timezone;
    @NotBlank(message = "CompanyType is mandatory")
    private CompanyType companyType;
    @NotBlank(message = "Industry is mandatory")
    private String industry;


}
