package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.OrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.SubOrganizationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubOrganizationDAO {
    OrganizationEntity getById(String regId);
    SubOrganizationEntity register( SubOrganizationEntity subOrganizationEntity);
     Page<SubOrganizationEntity> getAllSubOrganization(Pageable pageable);
    SubOrganizationEntity getBySubOrgId(String organizationId);
    SubOrganizationEntity saveTheChange(SubOrganizationEntity subOrganizationEntity);
    boolean existsById(String organizationId);//checking subOrganization by Id
    void deleteRecordById(String organizationId);

    void deleteSubOrganization(SubOrganizationEntity subOrganizationEntity);
}
