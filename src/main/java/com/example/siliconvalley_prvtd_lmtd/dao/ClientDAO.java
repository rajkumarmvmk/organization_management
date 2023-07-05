package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.ClientEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.ProjectsEntity;

import java.util.List;

public interface ClientDAO {
    ClientEntity register(ClientEntity clientEntity);
    ClientEntity fetchRecord(String clientCode);
    List<ClientEntity> getAll();
    ClientEntity saveTheChange(ClientEntity clientEntity);
    void deactivateTheRecord(ClientEntity clientEntity);
}
