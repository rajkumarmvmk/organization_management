package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.ClientEntity;
import com.example.siliconvalley_prvtd_lmtd.exception.CustomException;
import com.example.siliconvalley_prvtd_lmtd.exception.ErrorCodes;
import com.example.siliconvalley_prvtd_lmtd.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientDAOIMPL implements ClientDAO{
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public ClientEntity register(ClientEntity clientEntity){
        clientRepository.save(clientEntity);
        if(clientRepository.existsByClientCode(clientEntity.getClientCode())){
            ClientEntity clientEntity1=clientRepository.findByClientCode(clientEntity.getClientCode());
            return clientEntity1;
        }else{
            throw new CustomException(ErrorCodes.CODE_601.name(),ErrorCodes.CODE_601.getMessage());
        }

    }
    @Override
    public ClientEntity fetchRecord(String clientCode){
        if(clientRepository.existsByClientCode(clientCode)){
            ClientEntity clientEntity=clientRepository.findByClientCode(clientCode);
            return clientEntity;
        }else{
            throw new CustomException(ErrorCodes.CODE_602.name(),ErrorCodes.CODE_602.getMessage());
        }
    }
    @Override
    public List<ClientEntity> getAll(){
      List<ClientEntity> clientEntities=clientRepository.findAll();
      return clientEntities;


    }
    @Override
    public ClientEntity saveTheChange(ClientEntity clientEntity){
        clientRepository.save(clientEntity);
        if(clientRepository.existsByClientCode(clientEntity.getClientCode())){
            ClientEntity clientEntity1=clientRepository.findByClientCode(clientEntity.getClientCode());
            return clientEntity1;
        }else{
            throw new CustomException(ErrorCodes.CODE_602.name(),ErrorCodes.CODE_602.getMessage());
        }
    }
    @Override
    public void deactivateTheRecord(ClientEntity clientEntity){
       try{
           clientRepository.save(clientEntity);
       }catch (Exception e){
           throw  new CustomException(ErrorCodes.CODE_607.name(),ErrorCodes.CODE_607.getMessage());
       }
    }
}
