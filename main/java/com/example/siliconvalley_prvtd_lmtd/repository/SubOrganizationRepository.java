package com.example.siliconvalley_prvtd_lmtd.repository;

import com.example.siliconvalley_prvtd_lmtd.entity.SubOrganizationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubOrganizationRepository extends JpaRepository<SubOrganizationEntity,String> {
    SubOrganizationEntity findBySubOrganizationCode(String subOrganizationCode);
    Page<SubOrganizationEntity> findAll(Pageable pageable);
    SubOrganizationEntity getBySubOrganizationCode(String subOrganizationCode);
  //  boolean existsBySubOrganizationCode(String subOrganizationCode);
     void deleteBySubOrganizationCode(String subOrganizationCode);
}
