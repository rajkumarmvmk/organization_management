package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.dao.ClientDAO;
import com.example.siliconvalley_prvtd_lmtd.dao.ClientDAOIMPL;
import com.example.siliconvalley_prvtd_lmtd.dao.OrganizationDAO;
import com.example.siliconvalley_prvtd_lmtd.dao.SubOrganizationDAO;
import com.example.siliconvalley_prvtd_lmtd.entity.ClientEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.OrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.SubOrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ClientRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ClientResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class ClientServiceIMPL implements ClientService{
    @Autowired
    private ClientDAO clientDAO;
    @Autowired
    private OrganizationDAO organizationDAO;
    @Autowired
    private SubOrganizationDAO subOrganizationDAO;
    @Override
    public List<ClientResponseDTO>  registerToSubOrg(List<ClientRequestDTO> clientRequestDTOS,String subOrganizationCode){
        List<ClientResponseDTO> clientResponseDTOS =new ArrayList<>();
       SubOrganizationEntity subOrganizationEntity=subOrganizationDAO.getBySubOrgCode(subOrganizationCode);
       clientRequestDTOS.stream().forEach(list ->{
           ClientResponseDTO clientResponseDTO=new ClientResponseDTO();
           ClientEntity clientEntity= new ClientEntity();
           BeanUtils.copyProperties(list,clientEntity);
           clientEntity.setSubOrganizationEntity(subOrganizationEntity);
           ClientEntity clientEntity1=clientDAO.register(clientEntity);
           BeanUtils.copyProperties(clientEntity1,clientResponseDTO);
           clientResponseDTOS.add(clientResponseDTO);
       });
       return clientResponseDTOS;
    }
    @Override
    public List<ClientResponseDTO>  registerToOrg(List<ClientRequestDTO> clientRequestDTOS,String organizationCode){
        List<ClientResponseDTO> clientResponseDTOS =new ArrayList<>();
        OrganizationEntity organizationEntity =organizationDAO.fetchRecord(organizationCode);
        clientRequestDTOS.stream().forEach(list ->{
            ClientResponseDTO clientResponseDTO=new ClientResponseDTO();
            ClientEntity clientEntity= new ClientEntity();
            BeanUtils.copyProperties(list,clientEntity);
            log.info(String.valueOf(organizationEntity));
              clientEntity.setOrganizationEntity(organizationEntity);
            ClientEntity clientEntity1=clientDAO.register(clientEntity);
            BeanUtils.copyProperties(clientEntity1,clientResponseDTO);
            clientResponseDTOS.add(clientResponseDTO);
        });
        return clientResponseDTOS;
    }
}
