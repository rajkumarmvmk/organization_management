package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.dao.ClientDAO;
import com.example.siliconvalley_prvtd_lmtd.dao.ClientDAOIMPL;
import com.example.siliconvalley_prvtd_lmtd.dao.OrganizationDAO;
import com.example.siliconvalley_prvtd_lmtd.dao.SubOrganizationDAO;
import com.example.siliconvalley_prvtd_lmtd.entity.ClientEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.OrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.SubOrganizationEntity;
import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ClientRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ClientUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ClientResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static com.example.siliconvalley_prvtd_lmtd.enumBox.Status.ACTIVE;


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
    @Override
    public List<ClientResponseDTO> getAll(){
        List<ClientEntity> clientEntities = clientDAO.getAll();
        log.info("------------------"+clientEntities.toString());
        List<ClientResponseDTO> clientResponseDTOS=new ArrayList<>();
        Thread thread=new Thread();
        thread.start();
      //  Predicate<ClientEntity> startsWithAPredicate = name -> name.getStatus(Status.ACTIVE);
        clientEntities.stream().forEach(list -> {
            ClientResponseDTO clientResponseDTO=new ClientResponseDTO();
            BeanUtils.copyProperties(list,clientResponseDTO);
            try {
                Thread.sleep(5000); // Pause for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clientResponseDTOS.add(clientResponseDTO);

        });
        return clientResponseDTOS;

    }
    @Override
   public ClientResponseDTO updateClient(ClientUpdateRequestDTO clientUpdateRequestDTO, String clientCode){
        ClientEntity clientEntity=clientDAO.fetchRecord(clientCode);
        BeanUtils.copyProperties(clientUpdateRequestDTO,clientEntity);
        ClientEntity clientEntity1=clientDAO.saveTheChange(clientEntity);
        ClientResponseDTO clientResponseDTO=new ClientResponseDTO();
        BeanUtils.copyProperties(clientEntity1,clientResponseDTO);
        return clientResponseDTO;

    }
    @Override
   public  boolean deactivateRecordByClientCode(String clientCode, Status status){
        ClientEntity clientEntity=clientDAO.fetchRecord(clientCode);
        clientEntity.setStatus(status);
        clientDAO.deactivateTheRecord(clientEntity);
        return true;
    }
}
