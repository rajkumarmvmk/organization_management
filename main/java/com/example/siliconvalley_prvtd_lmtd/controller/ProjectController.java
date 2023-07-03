package com.example.siliconvalley_prvtd_lmtd.controller;

import com.example.siliconvalley_prvtd_lmtd.entity.ProjectsEntity;
import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import com.example.siliconvalley_prvtd_lmtd.exception.ErrorResponse;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ClientUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ProjectsRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ProjectsUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ClientResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ProjectsResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/Getall")
    public List<ProjectsResponseDTO> getAll(){
        List<ProjectsResponseDTO> projectsResponseDTOS=projectService.getAll();
        return projectsResponseDTOS;

    }
    @PutMapping(value="/update/{projectCode}")
    public ProjectsResponseDTO updateProjects(@RequestBody @Valid ProjectsUpdateRequestDTO projectsUpdateRequestDTO, @PathVariable(value="projectCode") String projectCode){
        ProjectsResponseDTO projectsResponseDTO=projectService.updateProject(projectsUpdateRequestDTO,projectCode);
        return projectsResponseDTO;
    }
    @DeleteMapping(value = "deactivate/{projectCode}/{status}")
    public ResponseEntity<?> deactivateRecordByProjectCode(@PathVariable(value = "projectCode") String projectCode, @PathVariable(value = "status") Status status) {
        if (projectService.deactivateRecordByProjectCode(projectCode,status)) {
            ErrorResponse errorResponse = new ErrorResponse("CODE_606", "given record deactivate successfully");

            return new ResponseEntity<>(errorResponse, HttpStatus.OK);
        } else {
            return null;

        }
    }

}
