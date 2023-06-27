package com.example.siliconvalley_prvtd_lmtd.repository;

import com.example.siliconvalley_prvtd_lmtd.entity.SubOrganizationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubOrganizationRepository extends JpaRepository<SubOrganizationEntity,String> {
    SubOrganizationEntity findByOrganizationId(String OrganizationID);
    Page<SubOrganizationEntity> findAll(Pageable pageable);
    SubOrganizationEntity getByOrganizationId(String organizationId);
    boolean existsByOrganizationId(String organizationId);
    void deleteByOrganizationId(String organizationId);
}
