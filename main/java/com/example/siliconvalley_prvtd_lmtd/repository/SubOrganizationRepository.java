package com.example.siliconvalley_prvtd_lmtd.repository;

import com.example.siliconvalley_prvtd_lmtd.entity.SubOrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubOrganizationRepository extends JpaRepository<SubOrganizationEntity,String> {
    SubOrganizationEntity findByOrganizationId(String OrganizationID);
}
