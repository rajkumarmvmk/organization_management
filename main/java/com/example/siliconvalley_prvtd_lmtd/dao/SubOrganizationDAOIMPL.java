package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.OrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.SubOrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.exception.CustomException;
import com.example.siliconvalley_prvtd_lmtd.exception.ErrorCodes;
import com.example.siliconvalley_prvtd_lmtd.repository.OrganizationRepository;
import com.example.siliconvalley_prvtd_lmtd.repository.SubOrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SubOrganizationDAOIMPL implements SubOrganizationDAO {
    @Autowired
    private SubOrganizationRepository subOrganizationRepository;
    @Autowired
    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationEntity getById(String regId){   //organization Id fetching
        if(organizationRepository.existsByOrganizationId(regId)){
            OrganizationEntity organizationEntity = organizationRepository.findByOrganizationId(regId);
            return organizationEntity;
        }else{
            throw new CustomException(ErrorCodes.CODE_602.name(), ErrorCodes.CODE_602.getMessage());
        }

    }
    @Override
    public SubOrganizationEntity register( SubOrganizationEntity subOrganizationEntity){
        try{
            log.info(String.valueOf(subOrganizationEntity));
            subOrganizationRepository.save(subOrganizationEntity);
            log.info("-----------------------------------------");
            SubOrganizationEntity subOrganizationEntity1 = subOrganizationRepository.findByOrganizationId(subOrganizationEntity.getOrganizationId());
            log.info(String.valueOf(subOrganizationEntity1));
            return subOrganizationEntity1;
        }catch (Exception e){
            throw new CustomException(ErrorCodes.CODE_601.name(),ErrorCodes.CODE_601.getMessage());
        }
    }
    @Override
    public Page<SubOrganizationEntity> getAllSubOrganization(Pageable pageable){
       try{
          Page<SubOrganizationEntity> subOrganizationEntityList = subOrganizationRepository.findAll(pageable);
          return subOrganizationEntityList;
       }catch (Exception e){
           throw new CustomException(ErrorCodes.CODE_602.name(),ErrorCodes.CODE_602.getMessage());
       }
    }
    @Override
    public SubOrganizationEntity getBySubOrgId(String organizationId){
        SubOrganizationEntity subOrganizationEntity = subOrganizationRepository.getByOrganizationId(organizationId);
        return subOrganizationEntity;
    }
    @Override
    public SubOrganizationEntity saveTheChange(SubOrganizationEntity subOrganizationEntity){
        try{
            subOrganizationRepository.save(subOrganizationEntity);
           SubOrganizationEntity subOrganizationEntity1 = subOrganizationRepository.getByOrganizationId(subOrganizationEntity.getOrganizationId());
           return  subOrganizationEntity1;
        }catch (Exception e){
            throw new CustomException(ErrorCodes.CODE_601.name(),ErrorCodes.CODE_601.getMessage());
        }
    }
    @Override
    public boolean existsById(String organizationId){
        boolean response = subOrganizationRepository.existsByOrganizationId(organizationId);
        return response;
    }
    @Override
    public void deleteRecordById(String organizationId){
        try{
            subOrganizationRepository.deleteByOrganizationId(organizationId);
              }catch(Exception e){
            throw  new CustomException(ErrorCodes.CODE_607.name(),ErrorCodes.CODE_607.getMessage());
        }

    }

    @Override
    public void deleteSubOrganization(SubOrganizationEntity subOrganizationEntity) {
        subOrganizationRepository.delete(subOrganizationEntity);
    }

}
