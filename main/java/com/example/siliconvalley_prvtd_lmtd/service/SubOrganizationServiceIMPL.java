package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.dao.SubOrganizationDAO;
import com.example.siliconvalley_prvtd_lmtd.entity.OrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.SubOrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.exception.CustomException;
import com.example.siliconvalley_prvtd_lmtd.exception.ErrorCodes;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.SubOrganizationIndexRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.SubOrganizationRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.SubOrganizationUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.OrganizationResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.SubOrganizationEndResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.SubOrganizationResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class SubOrganizationServiceIMPL implements SubOrganizationService{
    @Autowired
    private SubOrganizationDAO suborganizationDAO;
    @Override
    public SubOrganizationEndResponseDTO register(String regId,SubOrganizationIndexRequestDTO subOrganizationIndexRequestDTO){

        List<SubOrganizationResponseDTO> subOrganizationResponseDTOList = new ArrayList<>();

        subOrganizationIndexRequestDTO.getSubOrganizationRequestDTOList().stream().forEach(content ->{
            SubOrganizationResponseDTO subOrganizationResponseDTO = new SubOrganizationResponseDTO();
            SubOrganizationEntity subOrganizationEntity= new SubOrganizationEntity();
            BeanUtils.copyProperties(content,subOrganizationEntity);
            log.info(String.valueOf(subOrganizationEntity));
            OrganizationEntity organizationEntity =suborganizationDAO.getById(regId);
            subOrganizationEntity.setOrganizationEntity(organizationEntity);
            log.info(String.valueOf(subOrganizationEntity));
            SubOrganizationEntity subOrganizationEntity1 = suborganizationDAO.register(subOrganizationEntity);
            BeanUtils.copyProperties(subOrganizationEntity1,subOrganizationResponseDTO);
            subOrganizationResponseDTOList.add(subOrganizationResponseDTO);
        });
        SubOrganizationEndResponseDTO subOrganizationEndResponseDTO= new SubOrganizationEndResponseDTO() ;
        subOrganizationEndResponseDTO.setSubOrganizationResponseDTOList(subOrganizationResponseDTOList);
        OrganizationEntity organizationEntity =suborganizationDAO.getById(regId);
        OrganizationResponseDTO organizationResponseDTO =new OrganizationResponseDTO();
        BeanUtils.copyProperties(organizationEntity,organizationResponseDTO);
        subOrganizationEndResponseDTO.setOrganizationResponseDTO(organizationResponseDTO);
        return subOrganizationEndResponseDTO;
    }
    @Override
    public List<SubOrganizationResponseDTO> getAllSubOrganization(Pageable pageable){
        Page<SubOrganizationEntity> subOrganizationEntityList =suborganizationDAO.getAllSubOrganization(pageable);
        List<SubOrganizationResponseDTO> subOrganizationResponseDTOList=new ArrayList<>();

        subOrganizationEntityList.stream().forEach(list -> {
            SubOrganizationResponseDTO subOrganizationResponseDTO = new SubOrganizationResponseDTO();
            BeanUtils.copyProperties(list,subOrganizationResponseDTO);
            subOrganizationResponseDTOList.add(subOrganizationResponseDTO);
        });
        return subOrganizationResponseDTOList;
    }
    @Override
    public SubOrganizationResponseDTO updateOrganization(String organizationId, SubOrganizationUpdateRequestDTO subOrganizationUpdateRequestDTO){
     SubOrganizationEntity subOrganizationEntity=suborganizationDAO.getBySubOrgId(organizationId);
     BeanUtils.copyProperties(subOrganizationUpdateRequestDTO,subOrganizationEntity);
     SubOrganizationEntity subOrganizationEntity1=suborganizationDAO.saveTheChange(subOrganizationEntity);
     SubOrganizationResponseDTO subOrganizationResponseDTO = new SubOrganizationResponseDTO();
     BeanUtils.copyProperties(subOrganizationEntity1,subOrganizationResponseDTO);
     return subOrganizationResponseDTO;
    }
    @Override
    public boolean deleteRecordById(String organizationId){
        SubOrganizationEntity subOrganizationEntity = suborganizationDAO.getBySubOrgId(organizationId);
        if (subOrganizationEntity != null) {
           subOrganizationEntity.setOrganizationEntity(null);
           suborganizationDAO.deleteSubOrganization(subOrganizationEntity);

        if(suborganizationDAO.existsById(organizationId)){
            log.info("Entered");
            suborganizationDAO.deleteRecordById(organizationId);
            return true;

        }else{
            throw new CustomException(ErrorCodes.CODE_602.name(),ErrorCodes.CODE_602.getMessage());
        }

    }
}
