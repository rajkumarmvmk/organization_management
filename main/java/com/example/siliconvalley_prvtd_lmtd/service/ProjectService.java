package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.requestDTO.ProjectsRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ProjectsResponseDTO;

import java.util.List;

public interface ProjectService {
    List<ProjectsResponseDTO> registerToOrganization(List<ProjectsRequestDTO> projectsRequestDTOList, String organizationCode, String clientCode);
    List<ProjectsResponseDTO> registerToSubOrganization(List<ProjectsRequestDTO> projectsRequestDTOList,String subOrganizationCode,String clientCode);
    List<ProjectsResponseDTO> validate();
}
