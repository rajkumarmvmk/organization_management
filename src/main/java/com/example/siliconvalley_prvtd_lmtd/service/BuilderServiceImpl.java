package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.entity.ProjectsEntity;
import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import com.example.siliconvalley_prvtd_lmtd.repository.ClientRepository;
import com.example.siliconvalley_prvtd_lmtd.repository.ProjectRepository;
import com.example.siliconvalley_prvtd_lmtd.repository.ProjectRepositoryCustom;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ProjectsResponseDTO;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class BuilderServiceImpl implements BuilderService{
    @Autowired
    private ProjectRepositoryCustom projectRepositoryCustom;
   public  List<ProjectsResponseDTO> projectsByStatusAndProjectTitle(Status status, String projectTitle){
       log.info(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
      List<ProjectsEntity> projectsEntities =projectRepositoryCustom.findBooksByStatusAndProjectTitle(status,projectTitle);
     List<ProjectsResponseDTO> projectsResponseDTOList=new ArrayList<>();
      projectsEntities.stream().forEach(project->{
          ProjectsResponseDTO projectsResponseDTO=new ProjectsResponseDTO();
          BeanUtils.copyProperties(project,projectsResponseDTO);
          projectsResponseDTOList.add(projectsResponseDTO);

      });
      return projectsResponseDTOList;

    }


}



