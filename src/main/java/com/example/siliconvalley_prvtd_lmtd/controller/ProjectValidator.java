package com.example.siliconvalley_prvtd_lmtd.controller;

import com.example.siliconvalley_prvtd_lmtd.responseDTO.ProjectsResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.service.ProjectService;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/projectvalidator")
@PreAuthorize("hasRole('ADMIN')")
public class ProjectValidator {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private SessionFactory sessionFactory;

    @GetMapping(value = "/validate")
    public List<ProjectsResponseDTO> validating(){
        List<ProjectsResponseDTO> projectsResponseDTOS =projectService.validate();


            Statistics statistics = sessionFactory.getStatistics();
            long secondLevelCacheHitCount = statistics.getSecondLevelCacheHitCount();
            long secondLevelCacheMissCount = statistics.getSecondLevelCacheMissCount();
            long secondLevelCachePutCount = statistics.getSecondLevelCachePutCount();

            System.out.println("Second Level Cache Hit Count: " + secondLevelCacheHitCount);
            System.out.println("Second Level Cache Miss Count: " + secondLevelCacheMissCount);
            System.out.println("Second Level Cache Put Count: " + secondLevelCachePutCount);

        return projectsResponseDTOS;
    }

}
