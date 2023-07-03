package com.example.siliconvalley_prvtd_lmtd.controller;

import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import com.example.siliconvalley_prvtd_lmtd.exception.ErrorResponse;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.OrganizationRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.OrganizationUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.SubOrganizationUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.OrganizationResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ProjectsResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.SubOrganizationResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.service.OrganizationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;
    @PostMapping(value = "/register")
    public OrganizationResponseDTO register(@Valid @RequestBody OrganizationRequestDTO organizationRequestDTO){
        log.info(String.valueOf(organizationRequestDTO));
        OrganizationResponseDTO organizationResponseDTO=organizationService.register(organizationRequestDTO);
        log.info(String.valueOf(organizationRequestDTO));
        return organizationResponseDTO;
    }
    @GetMapping("/Getall")
    public List<OrganizationResponseDTO> getAll(){
        List<OrganizationResponseDTO> organizationResponseDTOS=organizationService.getAll();
        return organizationResponseDTOS;

    }
    @PutMapping(value = "update/{organizationCode}")
    public OrganizationResponseDTO updateOrganization(@PathVariable(value = "organizationCode") String organizationCode, @Valid @RequestBody OrganizationUpdateRequestDTO organizationUpdateRequestDTO) {
        OrganizationResponseDTO organizationResponseDTO = organizationService.updateOrganization(organizationCode, organizationUpdateRequestDTO);
        return organizationResponseDTO;
    }
    @DeleteMapping(value = "deactivate/{organizationCode}/{status}")
    public ResponseEntity<?> statusOfSubOrg(@PathVariable(value = "organizationCode") String organizationCode, @PathVariable(value = "status") Status status) {
        if (organizationService.statusOfOrg(organizationCode, status)) {
            ErrorResponse errorResponse = new ErrorResponse("CODE_606", "given record deactivated successfully");

            return new ResponseEntity<>(errorResponse, HttpStatus.OK);
        } else {
            return null;

        }
    }

}
