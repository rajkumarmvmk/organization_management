package com.example.siliconvalley_prvtd_lmtd.requestDTO;

import com.example.siliconvalley_prvtd_lmtd.enumBox.CompanyType;
import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientUpdateRequestDTO {

        @NotBlank
        private String clientName;


        private Status status;
        @NotBlank(message = "country is mandatory")
        private String country;
        @NotBlank(message = "timeZone is mandatory")
        private String timezone;

        private CompanyType companyType;
        @NotBlank(message = "industry is mandatory")
        private String industry;

    }

