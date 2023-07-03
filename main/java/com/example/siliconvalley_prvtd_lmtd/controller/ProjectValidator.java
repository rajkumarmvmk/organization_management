package com.example.siliconvalley_prvtd_lmtd.controller;

import com.example.siliconvalley_prvtd_lmtd.responseDTO.ProjectsResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/projectvalidator")
public class ProjectValidator {
    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "/validate")
    public List<ProjectsResponseDTO> validating(){
        List<ProjectsResponseDTO> projectsResponseDTOS =projectService.validate();
        return projectsResponseDTOS;
    }

}
