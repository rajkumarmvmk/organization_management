package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.requestDTO.SubOrganizationIndexRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.SubOrganizationEndResponseDTO;

public interface SubOrganizationService {
   SubOrganizationEndResponseDTO register(String regId, SubOrganizationIndexRequestDTO subOrganizationIndexRequestDTO);
}
