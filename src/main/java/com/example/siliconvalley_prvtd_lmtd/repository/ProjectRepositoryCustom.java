package com.example.siliconvalley_prvtd_lmtd.repository;

import com.example.siliconvalley_prvtd_lmtd.entity.ProjectsEntity;
import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;

import java.util.List;

public interface ProjectRepositoryCustom {
    List<ProjectsEntity> findBooksByStatusAndProjectTitle(Status Status, String ProjectTitle);
}
