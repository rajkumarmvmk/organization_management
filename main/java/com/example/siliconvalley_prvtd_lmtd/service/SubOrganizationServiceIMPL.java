package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.dao.SubOrganizationDAO;
import com.example.siliconvalley_prvtd_lmtd.entity.OrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.SubOrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.SubOrganizationIndexRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.SubOrganizationRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.SubOrganizationEndResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.SubOrganizationResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
        subOrganizationEndResponseDTO.setOrganizationEntity(organizationEntity);
        return subOrganizationEndResponseDTO;
    }
}
