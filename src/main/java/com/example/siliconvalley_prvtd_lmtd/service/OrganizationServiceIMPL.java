package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.dao.OrganizationDAO;
import com.example.siliconvalley_prvtd_lmtd.entity.OrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.ProjectsEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.SubOrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import com.example.siliconvalley_prvtd_lmtd.exception.CustomException;
import com.example.siliconvalley_prvtd_lmtd.exception.ErrorCodes;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.OrganizationRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.OrganizationUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.SubOrganizationUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.OrganizationResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ProjectsResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.SubOrganizationResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class OrganizationServiceIMPL implements OrganizationService {
    @Autowired
    private OrganizationDAO organizationDAO;
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public void printCacheStatistics() {
//        Statistics statistics = sessionFactory.getStatistics();
//        long secondLevelCacheHitCount = statistics.getSecondLevelCacheHitCount();
//        long secondLevelCacheMissCount = statistics.getSecondLevelCacheMissCount();
//        long secondLevelCachePutCount = statistics.getSecondLevelCachePutCount();
//
//        System.out.println("Second Level Cache Hit Count: " + secondLevelCacheHitCount);
//        System.out.println("Second Level Cache Miss Count: " + secondLevelCacheMissCount);
//        System.out.println("Second Level Cache Put Count: " + secondLevelCachePutCount);
//    }
    @Override
    public OrganizationResponseDTO register(OrganizationRequestDTO organizationRequestDTO) {
        log.debug("----------------------{}",organizationRequestDTO.getOrganizationCode());
        OrganizationEntity organizationEntity = new OrganizationEntity();
        OrganizationResponseDTO organizationResponseDTO = new OrganizationResponseDTO();
        BeanUtils.copyProperties(organizationRequestDTO, organizationEntity);
        OrganizationEntity organizationEntity1 = organizationDAO.registerInRepository(organizationEntity);

        BeanUtils.copyProperties(organizationEntity1, organizationResponseDTO);
        return organizationResponseDTO;

    }
    @Override
    public List<OrganizationResponseDTO> getAll(){
        List<OrganizationEntity> organizationEntities=organizationDAO.getAll();
        List<OrganizationResponseDTO> organizationResponseDTOS=new ArrayList<>();

        organizationEntities.stream().forEach(list->{
            OrganizationResponseDTO organizationResponseDTO=new OrganizationResponseDTO();
            BeanUtils.copyProperties(list,organizationResponseDTO);
            organizationResponseDTOS.add(organizationResponseDTO);
        });
        return organizationResponseDTOS;
    }
    @Override
    public OrganizationResponseDTO updateOrganization(String organizationCode, OrganizationUpdateRequestDTO organizationUpdateRequestDTO) {
        OrganizationEntity organizationEntity = organizationDAO.getByOrgCode(organizationCode);
        log.debug("---------------------------{}",organizationEntity.getOrganizationCode());
        BeanUtils.copyProperties(organizationUpdateRequestDTO, organizationEntity);
        OrganizationEntity organizationEntity1 = organizationDAO.saveTheChange(organizationEntity);
        log.debug("---------------------------{}",organizationEntity1.getOrganizationCode());
        OrganizationResponseDTO organizationResponseDTO = new OrganizationResponseDTO();
        BeanUtils.copyProperties(organizationEntity1, organizationResponseDTO);
        log.debug("---------------------------{}",organizationResponseDTO.getOrganizationCode());
        return organizationResponseDTO;
    }
    @Override
    public boolean statusOfOrg(String organizationCode, Status status) {
        OrganizationEntity organizationEntity = organizationDAO.getByOrgCode(organizationCode);
        log.debug("----------------------{}",organizationEntity.getOrganizationCode()+"-----available------");
        if (organizationEntity != null) {
            organizationEntity.setStatus(status);
            organizationDAO.saveTheChange(organizationEntity);
            return true;

        } else {
            log.error("---------------------data not exists---------------------------------");
            throw new CustomException(ErrorCodes.CODE_602.name(), ErrorCodes.CODE_602.getMessage());
        }

    }

}