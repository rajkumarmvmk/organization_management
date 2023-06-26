package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.dao.OrganizationDAO;
import com.example.siliconvalley_prvtd_lmtd.entity.OrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.OrganizationRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.OrganizationResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceIMPL implements OrganizationService {
    @Autowired
    private OrganizationDAO organizationDAO;
    @Override
    public OrganizationResponseDTO register(OrganizationRequestDTO organizationRequestDTO) {
        OrganizationEntity organizationEntity = new OrganizationEntity();
        OrganizationResponseDTO organizationResponseDTO = new OrganizationResponseDTO();
        BeanUtils.copyProperties(organizationRequestDTO, organizationEntity);
        OrganizationEntity organizationEntity1 = organizationDAO.registerInRepository(organizationEntity);

        BeanUtils.copyProperties(organizationEntity1, organizationResponseDTO);
        return organizationResponseDTO;

    }
}