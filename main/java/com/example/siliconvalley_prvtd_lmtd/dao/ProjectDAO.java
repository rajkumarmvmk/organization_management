package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.ProjectsEntity;

import java.util.List;

public interface ProjectDAO {
    ProjectsEntity registerToOrg(ProjectsEntity projectsEntity);
    List<ProjectsEntity> getRecords();
    ProjectsEntity admit(ProjectsEntity projectsEntity);
}
