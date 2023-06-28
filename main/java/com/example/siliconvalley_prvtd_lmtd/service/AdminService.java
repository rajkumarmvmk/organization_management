package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.entity.AdminEntity;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.AdminDTO;

public interface AdminService {
    AdminEntity registerAdmin(AdminDTO adminDTO);
    void saveVerificationTokenForAdmin(String token,AdminEntity adminEntity);
}
