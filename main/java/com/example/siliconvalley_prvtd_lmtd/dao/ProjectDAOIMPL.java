package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.ProjectsEntity;
import com.example.siliconvalley_prvtd_lmtd.exception.CustomException;
import com.example.siliconvalley_prvtd_lmtd.exception.ErrorCodes;
import com.example.siliconvalley_prvtd_lmtd.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ProjectDAOIMPL implements ProjectDAO{
    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public ProjectsEntity registerToOrg(ProjectsEntity projectsEntity){
        projectRepository.save(projectsEntity);
        if(projectRepository.existsByProjectCode(projectsEntity.getProjectCode())){
            ProjectsEntity projectsEntity1=projectRepository.findByProjectCode(projectsEntity.getProjectCode());
            return projectsEntity1;
        }else{
            throw new CustomException(ErrorCodes.CODE_601.name(),ErrorCodes.CODE_601.getMessage());
        }


    }
    @Override
    public List<ProjectsEntity> getRecords(){
      try{
          List<ProjectsEntity> projectsEntityList = projectRepository.findAll();
          return projectsEntityList;
      }catch (Exception e){
          throw new CustomException(ErrorCodes.CODE_602.name(),ErrorCodes.CODE_602.getMessage());
      }
    }
    @Override
    public ProjectsEntity admit(ProjectsEntity projectsEntity){
        try{
            projectRepository.save(projectsEntity);
            ProjectsEntity projectsEntity1=projectRepository.findByProjectCode(projectsEntity.getProjectCode());
            return projectsEntity1;
        }catch (Exception e){
            throw new CustomException(ErrorCodes.CODE_601.name(),ErrorCodes.CODE_601.getMessage());
        }
    }

}
