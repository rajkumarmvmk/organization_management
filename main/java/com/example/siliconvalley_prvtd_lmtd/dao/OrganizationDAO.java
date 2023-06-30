package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.OrganizationEntity;

public interface OrganizationDAO {
     OrganizationEntity registerInRepository(OrganizationEntity organizationEntity);
      OrganizationEntity fetchRecord(String organizationCode);
}
