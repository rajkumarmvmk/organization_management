package com.example.siliconvalley_prvtd_lmtd.requestDTO;

import com.example.siliconvalley_prvtd_lmtd.enumBox.CompanyType;
import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrganizationUpdateRequestDTO {



    @NotBlank(message = "Name is mandatory")
    private String organizationName;

    private Status status;

    @NotBlank(message = "Name is mandatory")
    private String country;

    @NotBlank(message = "Name is mandatory")
    private String timezone;

    private CompanyType companyType;
    @NotBlank(message = "Name is mandatory")
    private String industry;
}
