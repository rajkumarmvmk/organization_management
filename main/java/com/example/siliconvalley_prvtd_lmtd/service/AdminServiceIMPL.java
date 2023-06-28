package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.dao.AdminDAO;
import com.example.siliconvalley_prvtd_lmtd.entity.AdminEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.VerificationToken;
import com.example.siliconvalley_prvtd_lmtd.repository.VerificationTokenRepository;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.AdminDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceIMPL implements AdminService{
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    @Autowired
    private AdminDAO adminDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
   public AdminEntity registerAdmin(AdminDTO adminDTO){

    AdminEntity adminEntity = new AdminEntity();
        adminEntity.setFirstName(adminDTO.getFirstName());
        adminEntity.setLastName(adminDTO.getLastName());
        adminEntity.setEmail(adminDTO.getEmail());
        adminEntity.setRole("ADMIN");
        adminEntity.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
        adminDAO.saveTheAdmin(adminEntity);
        return adminEntity;
    }
    @Override
    public void saveVerificationTokenForAdmin(String token,AdminEntity adminEntity){
        VerificationToken verificationToken= new VerificationToken(adminEntity,token);
        verificationTokenRepository.save(verificationToken);

    }
}
