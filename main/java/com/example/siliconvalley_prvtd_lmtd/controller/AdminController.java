package com.example.siliconvalley_prvtd_lmtd.controller;

import com.example.siliconvalley_prvtd_lmtd.entity.AdminEntity;
import com.example.siliconvalley_prvtd_lmtd.event.RegistrationCompleteEvent;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.AdminDTO;
import com.example.siliconvalley_prvtd_lmtd.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    private AdminService adminService;
    @PostMapping(value = "/register")
    public String registerAdmin(@RequestBody AdminDTO adminDTO, final HttpServletRequest request){
        AdminEntity adminEntity=adminService.registerAdmin(adminDTO);
        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(adminEntity,applicationUrl(request)));
        return "success";


    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    }

}
