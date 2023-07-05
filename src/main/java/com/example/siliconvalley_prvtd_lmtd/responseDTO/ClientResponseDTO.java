package com.example.siliconvalley_prvtd_lmtd.responseDTO;

import com.example.siliconvalley_prvtd_lmtd.enumBox.CompanyType;
import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResponseDTO {

        private String clientCode;
        private String clientName;
        private Status status;
        private String country;
        private String timezone;
        private CompanyType companyType;
        private String industry;

    }

