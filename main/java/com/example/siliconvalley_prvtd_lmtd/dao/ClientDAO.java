package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.ClientEntity;

public interface ClientDAO {
    ClientEntity register(ClientEntity clientEntity);
    ClientEntity fetchRecord(String clientCode);
}
