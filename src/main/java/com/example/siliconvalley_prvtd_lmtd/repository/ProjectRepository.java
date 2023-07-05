package com.example.siliconvalley_prvtd_lmtd.repository;

import com.example.siliconvalley_prvtd_lmtd.entity.ProjectsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectsEntity,String> {
    boolean existsByProjectCode(String projectCode);
    ProjectsEntity findByProjectCode(String projectCode);

}
