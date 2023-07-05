package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.SubOrganizationIndexRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.SubOrganizationRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.SubOrganizationUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.SubOrganizationEndResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.SubOrganizationResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubOrganizationService {
   SubOrganizationEndResponseDTO registerSubOrganization(String organizationCode, SubOrganizationIndexRequestDTO subOrganizationIndexRequestDTO);
   List<SubOrganizationResponseDTO> getAllSubOrganization(Pageable pageable);
   SubOrganizationResponseDTO updateSubOrganization(String subOrganizationCode, SubOrganizationUpdateRequestDTO subOrganizationUpdateRequestDTO);
    boolean deleteRecordBySubOrgCode(String subOrganizationCode);
    boolean statusOfSubOrg(String subOrganizationCode, Status status);
}
