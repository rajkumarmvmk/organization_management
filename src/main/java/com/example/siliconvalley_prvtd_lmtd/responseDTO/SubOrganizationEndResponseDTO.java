package com.example.siliconvalley_prvtd_lmtd.responseDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class SubOrganizationEndResponseDTO {
    private List<SubOrganizationResponseDTO> subOrganizationResponseDTOList;
    private OrganizationResponseDTO organizationResponseDTO;

}
