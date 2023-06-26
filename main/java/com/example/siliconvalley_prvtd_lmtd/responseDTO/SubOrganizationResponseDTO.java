package com.example.siliconvalley_prvtd_lmtd.responseDTO;

import com.example.siliconvalley_prvtd_lmtd.enumBox.CompanyType;
import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class SubOrganizationResponseDTO {

        private String organizationId;
        private String name;
        private Status status;
        private String country;
        private String timezone;
        private CompanyType companyType;
        private String industry;

    }

