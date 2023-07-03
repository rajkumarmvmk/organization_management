package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.OrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.SubOrganizationEntity;

import java.util.List;

public interface OrganizationDAO {
     OrganizationEntity registerInRepository(OrganizationEntity organizationEntity);
      OrganizationEntity fetchRecord(String organizationCode);
    List<OrganizationEntity> getAll();
    OrganizationEntity getByOrgCode(String organizationCode);
    OrganizationEntity saveTheChange(OrganizationEntity organizationEntity);
}
