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
    public OrganizationEntity fetching(String organizationCode){   //organization Id fetching
        if(organizationRepository.existsByOrganizationCode(organizationCode)){
            OrganizationEntity organizationEntity = organizationRepository.findByOrganizationCode(organizationCode);
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
            SubOrganizationEntity subOrganizationEntity1 = subOrganizationRepository.findBySubOrganizationCode(subOrganizationEntity.getSubOrganizationCode());
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
    public SubOrganizationEntity getBySubOrgCode(String subOrganizationCode){
        SubOrganizationEntity subOrganizationEntity = subOrganizationRepository.findBySubOrganizationCode(subOrganizationCode);
        return subOrganizationEntity;
    }
    @Override
    public SubOrganizationEntity saveTheChange(SubOrganizationEntity subOrganizationEntity){
        try{
            subOrganizationRepository.save(subOrganizationEntity);
           SubOrganizationEntity subOrganizationEntity1 = subOrganizationRepository.getBySubOrganizationCode(subOrganizationEntity.getSubOrganizationCode());
           return  subOrganizationEntity1;
        }catch (Exception e){
            throw new CustomException(ErrorCodes.CODE_601.name(),ErrorCodes.CODE_601.getMessage());
        }
    }


    @Override
    public void deleteSubOrganization(SubOrganizationEntity subOrganizationEntity) {
        subOrganizationRepository.deleteBySubOrganizationCode(subOrganizationEntity.getSubOrganizationCode());
    }

}
