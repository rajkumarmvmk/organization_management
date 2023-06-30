package com.example.siliconvalley_prvtd_lmtd.controller;

import com.example.siliconvalley_prvtd_lmtd.entity.ProjectsEntity;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ProjectsRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ProjectsResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @PostMapping("/register/org/{organizationCode}/{clientCode}")
    public List<ProjectsResponseDTO> registerToOrganization(@RequestBody @Valid List<ProjectsRequestDTO> projectsRequestDTOList, @PathVariable(value = "organizationCode") String organizationCode,@PathVariable(value = "clientCode") String clientCode){
        List<ProjectsResponseDTO> projectsResponseDTOS =projectService.registerToOrganization(projectsRequestDTOList,organizationCode,clientCode);
        return projectsResponseDTOS;

    }
    @PostMapping("/register/SubOrg/{subOrganizationCode}/{clientCode}")
    public List<ProjectsResponseDTO> registerToSubOrganization(@RequestBody @Valid List<ProjectsRequestDTO> projectsRequestDTOList, @PathVariable(value = "subOrganizationCode") String subOrganizationCode,@PathVariable(value = "clientCode") String clientCode){
        List<ProjectsResponseDTO> projectsResponseDTOS =projectService.registerToSubOrganization(projectsRequestDTOList,subOrganizationCode,clientCode);
        return projectsResponseDTOS;

    }

}
