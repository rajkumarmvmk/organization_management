package com.example.siliconvalley_prvtd_lmtd.responseDTO;

import com.example.siliconvalley_prvtd_lmtd.entity.OrganizationEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class SubOrganizationEndResponseDTO {
    private List<SubOrganizationResponseDTO> subOrganizationResponseDTOList;
    private OrganizationEntity organizationEntity;

}
