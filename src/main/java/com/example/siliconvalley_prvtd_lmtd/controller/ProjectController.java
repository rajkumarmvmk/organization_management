package com.example.siliconvalley_prvtd_lmtd.controller;

import com.example.siliconvalley_prvtd_lmtd.entity.ProjectsEntity;
import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import com.example.siliconvalley_prvtd_lmtd.exception.ErrorResponse;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ClientUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ProjectsRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ProjectsUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ClientResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ProjectsResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.service.BuilderService;
import com.example.siliconvalley_prvtd_lmtd.service.ProjectService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("api/v1/project")
@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
public class ProjectController {
    @Autowired
    private BuilderService builderService;
    @Autowired
    private ProjectService projectService;
    @PostMapping("/register/org")
    public List<ProjectsResponseDTO> registerToOrganization(@RequestBody @Valid List<ProjectsRequestDTO> projectsRequestDTOList, @RequestParam(value = "organizationCode") String organizationCode,@RequestParam(value = "clientCode") String clientCode){
        List<ProjectsResponseDTO> projectsResponseDTOS =projectService.registerToOrganization(projectsRequestDTOList,organizationCode,clientCode);
        return projectsResponseDTOS;

    }
    @PostMapping("/register/SubOrg")
    public List<ProjectsResponseDTO> registerToSubOrganization(@RequestBody @Valid List<ProjectsRequestDTO> projectsRequestDTOList, @RequestParam(value = "subOrganizationCode") String subOrganizationCode,@RequestParam(value = "clientCode") String clientCode){
        List<ProjectsResponseDTO> projectsResponseDTOS =projectService.registerToSubOrganization(projectsRequestDTOList,subOrganizationCode,clientCode);
        return projectsResponseDTOS;

    }
    @GetMapping("/Getall")
    public List<ProjectsResponseDTO> getAll(){
        List<ProjectsResponseDTO> projectsResponseDTOS=projectService.getAll();
        return projectsResponseDTOS;

    }
    @PutMapping(value="/update")
    public ProjectsResponseDTO updateProjects(@RequestBody @Valid ProjectsUpdateRequestDTO projectsUpdateRequestDTO, @RequestParam(value="projectCode") String projectCode){
        ProjectsResponseDTO projectsResponseDTO=projectService.updateProject(projectsUpdateRequestDTO,projectCode);
        return projectsResponseDTO;
    }
    @DeleteMapping(value = "deactivate")
    public ResponseEntity<?> deactivateRecordByProjectCode(@RequestParam(value = "projectCode") String projectCode, @RequestParam(value = "status") Status status) {
        if (projectService.deactivateRecordByProjectCode(projectCode,status)) {
            ErrorResponse errorResponse = new ErrorResponse("CODE_606", "given record deactivate successfully");
            log.info("-------------------------"+projectCode+"-deactivated successfully-----------------");
            return new ResponseEntity<>(errorResponse, HttpStatus.OK);
        } else {
            return null;

        }
    }
    @GetMapping(value="search")
    public List<ProjectsResponseDTO> projectsByStatusAndProjectTitle(@RequestParam(value = "status")Status status,@RequestParam(value = "projectTitle") String projectTitle ){
      return builderService.projectsByStatusAndProjectTitle(status,projectTitle);
    }

}
