package com.example.siliconvalley_prvtd_lmtd.controller;

import com.example.siliconvalley_prvtd_lmtd.requestDTO.SubOrganizationIndexRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.SubOrganizationRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.SubOrganizationEndResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.SubOrganizationResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.service.SubOrganizationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("api/v1/suborganization")
public class SubOrganizationController {
    @Autowired
    private SubOrganizationService subOrganizationService;
    @PostMapping(value = "regsiter/{id}")
    public SubOrganizationEndResponseDTO register(@PathVariable(value="id") String regId, @RequestBody @Valid SubOrganizationIndexRequestDTO subOrganizationIndexRequestDTO){
        log.info(subOrganizationIndexRequestDTO.toString());
        SubOrganizationEndResponseDTO subOrganizationEndResponseDTO =subOrganizationService.register(regId,subOrganizationIndexRequestDTO);
        return subOrganizationEndResponseDTO;
    }
}
