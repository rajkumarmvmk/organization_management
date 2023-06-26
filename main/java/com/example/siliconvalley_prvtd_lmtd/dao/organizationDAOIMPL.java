package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.OrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.exception.CustomException;
import com.example.siliconvalley_prvtd_lmtd.exception.ErrorCodes;
import com.example.siliconvalley_prvtd_lmtd.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class organizationDAOIMPL implements OrganizationDAO{
    @Autowired
    private OrganizationRepository organizationRepository;
    public OrganizationEntity registerInRepository(OrganizationEntity organizationEntity){
       try{    log.info(String.valueOf(organizationEntity));
           organizationRepository.save(organizationEntity);
           return organizationEntity;
       }catch(Exception e){
           throw new CustomException(ErrorCodes.CODE_601.name(),ErrorCodes.CODE_601.getMessage());
       }
    }
}
