package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.OrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.SubOrganizationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubOrganizationDAO {
    OrganizationEntity fetching(String organizationCode);
    SubOrganizationEntity register( SubOrganizationEntity subOrganizationEntity);
     Page<SubOrganizationEntity> getAllSubOrganization(Pageable pageable);
    SubOrganizationEntity getBySubOrgCode(String subOrganizationCode);
    SubOrganizationEntity saveTheChange(SubOrganizationEntity subOrganizationEntity);
    void deleteSubOrganization(SubOrganizationEntity subOrganizationEntity);
}
