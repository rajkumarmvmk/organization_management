package com.example.siliconvalley_prvtd_lmtd.requestDTO;


import com.example.siliconvalley_prvtd_lmtd.enumBox.CompanyType;
import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubOrganizationRequestDTO {

        @NotNull(message = "Name is mandatory")
        private String organizationId;
        @NotBlank(message = "Name is mandatory")
        private String name;
        @NotBlank(message = "Name is mandatory")
        private Status status;

        @NotBlank(message = "Name is mandatory")
        private String country;
        @NotBlank(message = "Name is mandatory")
        private String timezone;
        @NotBlank(message = "Name is mandatory")
        private CompanyType companyType;
        @NotBlank(message = "Name is mandatory")
        private String industry;

    }

