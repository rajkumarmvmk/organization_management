package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.dao.ClientDAO;
import com.example.siliconvalley_prvtd_lmtd.dao.OrganizationDAO;
import com.example.siliconvalley_prvtd_lmtd.dao.ProjectDAOIMPL;
import com.example.siliconvalley_prvtd_lmtd.dao.SubOrganizationDAO;
import com.example.siliconvalley_prvtd_lmtd.entity.ClientEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.OrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.ProjectsEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.SubOrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import com.example.siliconvalley_prvtd_lmtd.exception.CustomException;
import com.example.siliconvalley_prvtd_lmtd.exception.ErrorCodes;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ProjectsRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ProjectsUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ProjectsResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProjectServiceIMPL implements ProjectService {
    @Autowired
    private SubOrganizationDAO subOrganizationDAO;
    @Autowired
    private OrganizationDAO organizationDAO;
    @Autowired
    private ClientDAO clientDAO;
    @Autowired
    private ProjectDAOIMPL projectDAO;
    @Override
    public List<ProjectsResponseDTO> registerToOrganization(List<ProjectsRequestDTO> projectsRequestDTOList,String organizationCode,String clientCode){
        OrganizationEntity organizationEntity =organizationDAO.fetchRecord(organizationCode);
        ClientEntity clientEntity=clientDAO.fetchRecord(clientCode);
        List<ProjectsResponseDTO> projectsResponseDTOS=new ArrayList<>();
        projectsRequestDTOList.stream().forEach(list ->{
            ProjectsEntity projectsEntity=new ProjectsEntity();
            ProjectsResponseDTO projectsResponseDTO=new ProjectsResponseDTO();
            BeanUtils.copyProperties(list,projectsEntity);
            projectsEntity.setOrganizationEntity(organizationEntity);
            projectsEntity.setClientEntity(clientEntity);
            ProjectsEntity projectsEntity1=projectDAO.registerToOrg(projectsEntity);
            BeanUtils.copyProperties(projectsEntity1,projectsResponseDTO);
            projectsResponseDTOS.add(projectsResponseDTO);

        });
       return projectsResponseDTOS;
   }
    @Override
    public List<ProjectsResponseDTO> registerToSubOrganization(List<ProjectsRequestDTO> projectsRequestDTOList,String subOrganizationCode,String clientCode){
        SubOrganizationEntity subOrganizationEntity = subOrganizationDAO.getBySubOrgCode(subOrganizationCode);
        ClientEntity clientEntity=clientDAO.fetchRecord(clientCode);
        List<ProjectsResponseDTO> projectsResponseDTOS=new ArrayList<>();
        projectsRequestDTOList.stream().forEach(list ->{
            ProjectsEntity projectsEntity=new ProjectsEntity();
            ProjectsResponseDTO projectsResponseDTO=new ProjectsResponseDTO();
            BeanUtils.copyProperties(list,projectsEntity);
            projectsEntity.setSubOrganizationEntity(subOrganizationEntity);
            projectsEntity.setClientEntity(clientEntity);
            ProjectsEntity projectsEntity1=projectDAO.registerToOrg(projectsEntity);
            BeanUtils.copyProperties(projectsEntity1,projectsResponseDTO);
            projectsResponseDTOS.add(projectsResponseDTO);

        });
        return projectsResponseDTOS;
    }
    @Override
    public  List<ProjectsResponseDTO> validate(){
       List<ProjectsEntity> projectsEntityList =projectDAO.getRecords();
       List<ProjectsResponseDTO> projectsResponseDTOS=new ArrayList<>();
       projectsEntityList.stream().forEach(list-> {
           LocalDate currentDate = LocalDate.now();
           log.info(String.valueOf(currentDate));

           LocalDate dateBaseRecordDate = list.getEndDate();
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
           String formattedString = dateBaseRecordDate.format(formatter);
           LocalDate endDate = LocalDate.parse(formattedString);
           log.info(String.valueOf(endDate));
           if (endDate.isBefore(currentDate)) {
               ProjectsResponseDTO projectsResponseDTO = new ProjectsResponseDTO();
               list.setStatus(Status.INACTIVE);
               ProjectsEntity projectsEntity = projectDAO.admit(list);
               BeanUtils.copyProperties(projectsEntity, projectsResponseDTO);
               projectsResponseDTOS.add(projectsResponseDTO);
           } else {
                System.out.println("--------------------record ok__________--------------");
           }
       });
              return projectsResponseDTOS;

    }
    @Override
    public List<ProjectsResponseDTO> getAll(){
        List<ProjectsEntity> projectsEntityList=projectDAO.getAll();
        List<ProjectsResponseDTO> projectsResponseDTOS=new ArrayList<>();

        projectsEntityList.stream().forEach(list->{
            ProjectsResponseDTO projectsResponseDTO = new ProjectsResponseDTO();
            BeanUtils.copyProperties(list,projectsResponseDTO);
            projectsResponseDTOS.add(projectsResponseDTO);
        });
        return projectsResponseDTOS;
    }
    @Override
    public ProjectsResponseDTO updateProject(ProjectsUpdateRequestDTO projectsUpdateRequestDTO, String projectCode){
        ProjectsEntity projectsEntity =projectDAO.getTheRecords(projectCode);
        BeanUtils.copyProperties(projectsUpdateRequestDTO,projectsEntity);
        ProjectsEntity projectsEntity1  =projectDAO.saveTheChange(projectsEntity);
        ProjectsResponseDTO projectsResponseDTO=new ProjectsResponseDTO();
        BeanUtils.copyProperties(projectsEntity1,projectsResponseDTO);
        return projectsResponseDTO;
    }
    @Override
    public  boolean deactivateRecordByProjectCode(String projectCode, Status status){
        ProjectsEntity projectsEntity=projectDAO.getTheRecords(projectCode);
        projectsEntity.setStatus(status);
        projectDAO.deactivateTheRecord(projectsEntity);
        return true;
    }
}

