package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.ClientEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.OrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.SubOrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.exception.CustomException;
import com.example.siliconvalley_prvtd_lmtd.exception.ErrorCodes;
import com.example.siliconvalley_prvtd_lmtd.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class organizationDAOIMPL implements OrganizationDAO{
    @Autowired
    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationEntity registerInRepository(OrganizationEntity organizationEntity){
       try{    log.info(String.valueOf(organizationEntity));
           organizationRepository.save(organizationEntity);
           return organizationEntity;
       }catch(Exception e){
           throw new CustomException(ErrorCodes.CODE_601.name(),ErrorCodes.CODE_601.getMessage());
       }
    }
    @Override
    public OrganizationEntity fetchRecord(String organizationCode){
        OrganizationEntity organizationEntity=organizationRepository.findByOrganizationCode(organizationCode);
        return organizationEntity;
    }
    @Override
    public List<OrganizationEntity> getAll(){
        List<OrganizationEntity> organizationEntities=organizationRepository.findAll();
        return organizationEntities;
    }
    @Override
    public OrganizationEntity getByOrgCode(String organizationCode){
        OrganizationEntity organizationEntity = organizationRepository.findByOrganizationCode(organizationCode);
        return organizationEntity;
    }
    @Override
    public OrganizationEntity saveTheChange(OrganizationEntity organizationEntity){
        try{
            organizationRepository.save(organizationEntity);
            OrganizationEntity organizationEntity1 = organizationRepository.getByOrganizationCode(organizationEntity.getOrganizationCode());
            return  organizationEntity1;
        }catch (Exception e){
            throw new CustomException(ErrorCodes.CODE_601.name(),ErrorCodes.CODE_601.getMessage());
        }
    }

}
