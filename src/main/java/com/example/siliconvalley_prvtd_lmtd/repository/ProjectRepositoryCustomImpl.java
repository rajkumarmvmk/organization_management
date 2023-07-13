package com.example.siliconvalley_prvtd_lmtd.repository;

import com.example.siliconvalley_prvtd_lmtd.entity.ProjectsEntity;
import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.util.Predicates;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProjectRepositoryCustomImpl implements ProjectRepositoryCustom{
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<ProjectsEntity> findBooksByStatusAndProjectTitle(Status status, String projectTitle) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProjectsEntity> criteriaBuilderQuery = criteriaBuilder.createQuery(ProjectsEntity.class);

        Root<ProjectsEntity> project = criteriaBuilderQuery.from(ProjectsEntity.class);
        List<Predicate> predicates = new ArrayList<>();

        if (status != null) {
            predicates.add( criteriaBuilder.equal(project.get("status"),status));
        }
        if (projectTitle != null) {
            predicates.add( criteriaBuilder.like(project.get("projectTitle"), "%" + projectTitle + "%"));
        }
        criteriaBuilderQuery.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(criteriaBuilderQuery).getResultList();
        }
    }

