package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.ClientEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.ProjectsEntity;

import java.util.List;
import java.util.Optional;

public interface ProjectDAO {
    ProjectsEntity registerToOrg(ProjectsEntity projectsEntity);
    List<ProjectsEntity> getRecords();
    ProjectsEntity admit(ProjectsEntity projectsEntity);
    List<ProjectsEntity> getAll();
    ProjectsEntity getTheRecords(String projectCode);
    ProjectsEntity saveTheChange(ProjectsEntity projectsEntity);
    void deactivateTheRecord(ProjectsEntity projectsEntity);
}
