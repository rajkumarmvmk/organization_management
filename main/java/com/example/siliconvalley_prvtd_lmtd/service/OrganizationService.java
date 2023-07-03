package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.OrganizationRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.OrganizationUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.OrganizationResponseDTO;

import java.util.List;

public interface OrganizationService {
     OrganizationResponseDTO register(OrganizationRequestDTO organizationRequestDTO);
     List<OrganizationResponseDTO> getAll();
     OrganizationResponseDTO updateOrganization(String organizationCode, OrganizationUpdateRequestDTO organizationUpdateRequestDTO);
     boolean statusOfOrg(String organizationCode, Status status);
}
