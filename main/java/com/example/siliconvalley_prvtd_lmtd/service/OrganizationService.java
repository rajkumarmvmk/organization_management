package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.requestDTO.OrganizationRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.OrganizationResponseDTO;

public interface OrganizationService {
     OrganizationResponseDTO register(OrganizationRequestDTO organizationRequestDTO);
}
