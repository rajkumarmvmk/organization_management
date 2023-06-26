package com.example.siliconvalley_prvtd_lmtd.controller;

import com.example.siliconvalley_prvtd_lmtd.requestDTO.OrganizationRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.OrganizationResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.service.OrganizationService;
import com.example.siliconvalley_prvtd_lmtd.service.OrganizationServiceIMPL;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("api/v1/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;
    @PostMapping(value = "/register")
    public OrganizationResponseDTO register(@RequestBody @Valid OrganizationRequestDTO organizationRequestDTO){
        log.info(String.valueOf(organizationRequestDTO));
        OrganizationResponseDTO organizationResponseDTO=organizationService.register(organizationRequestDTO);
        log.info(String.valueOf(organizationRequestDTO));
        return organizationResponseDTO;
    }

}
