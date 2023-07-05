package com.example.siliconvalley_prvtd_lmtd.repository;

import com.example.siliconvalley_prvtd_lmtd.entity.OrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.SubOrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationEntity,String> {
    OrganizationEntity findByOrganizationCode(String organizationCode);
    boolean existsByOrganizationCode(String organizationCode);
    OrganizationEntity getByOrganizationCode(String organizationCode);
}
