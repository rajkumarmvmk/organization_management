package com.example.siliconvalley_prvtd_lmtd.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProjectBelongToOrganizationRequestDTO {
    public class OrganizationEntity {
        @NotNull(message = "Name is mandatory")
        private Long clientOrganizationCode;
        @NotBlank(message = "Name is mandatory")
        private String clientOrganizationName;
        @NotBlank(message = "Name is mandatory")
        private String Status;
        @NotNull(message = "Name is mandatory")
        private Integer totalEmployees;
        @NotBlank(message = "Name is mandatory")
        private String defaultCountry;
        @NotBlank(message = "Name is mandatory")
        private String defaultTimezone;
        @NotBlank(message = "Name is mandatory")
        private String companyType;
        @NotBlank(message = "Name is mandatory")
        private String industry;

    }
}
