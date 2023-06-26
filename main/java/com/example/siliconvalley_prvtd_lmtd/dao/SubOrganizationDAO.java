package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.OrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.SubOrganizationEntity;

public interface SubOrganizationDAO {
    OrganizationEntity getById(String regId);
    SubOrganizationEntity register( SubOrganizationEntity subOrganizationEntity);
}
