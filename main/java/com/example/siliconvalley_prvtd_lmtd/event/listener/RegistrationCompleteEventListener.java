package com.example.siliconvalley_prvtd_lmtd.event.listener;

import com.example.siliconvalley_prvtd_lmtd.entity.AdminEntity;
import com.example.siliconvalley_prvtd_lmtd.event.RegistrationCompleteEvent;
import com.example.siliconvalley_prvtd_lmtd.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    @Autowired
    private AdminService adminService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        AdminEntity adminEntity=event.getAdminEntity();
        String token = UUID.randomUUID().toString();
        adminService.saveVerificationTokenForAdmin(token,adminEntity);
        String url= event.getApplicationUrl()+"verifyRegistration?token="+token;
        log.info("click the link to verify your account:{}",url);

    }
}
