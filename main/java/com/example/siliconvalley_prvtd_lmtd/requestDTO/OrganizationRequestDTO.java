package com.example.siliconvalley_prvtd_lmtd.requestDTO;

import com.example.siliconvalley_prvtd_lmtd.enumBox.CompanyType;
import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrganizationRequestDTO {

    @NotBlank(message = "Id is mandatory")
    private String organizationCode;
    @NotBlank(message = "Name is mandatory")
    private String organizationName;

    private Status  status;
    @NotBlank(message = "Country is mandatory")
    private String country;
    @NotBlank(message = "timeZone is mandatory")
    private String timezone;

    private CompanyType companyType;
    @NotBlank(message = "Industry is mandatory")
    private String industry;


}
