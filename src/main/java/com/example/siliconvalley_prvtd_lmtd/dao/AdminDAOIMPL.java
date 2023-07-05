package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.AdminEntity;
import com.example.siliconvalley_prvtd_lmtd.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDAOIMPL implements AdminDAO{
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public void saveTheAdmin(AdminEntity adminEntity){
        adminRepository.save(adminEntity);
    }
}
