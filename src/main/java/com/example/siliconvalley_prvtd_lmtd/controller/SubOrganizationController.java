package com.example.siliconvalley_prvtd_lmtd.controller;

import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import com.example.siliconvalley_prvtd_lmtd.exception.ErrorResponse;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.SubOrganizationIndexRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.SubOrganizationRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.SubOrganizationUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.SubOrganizationEndResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.SubOrganizationResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.service.SubOrganizationService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("api/v1/suborganization")
@PreAuthorize("hasRole('ADMIN')")
public class SubOrganizationController {
    @Autowired
    private SubOrganizationService subOrganizationService;
     @Transactional
    @PostMapping(value = "register")
    public SubOrganizationEndResponseDTO register(@RequestParam(value = "organizationCode") String organizationCode, @Valid @RequestBody SubOrganizationIndexRequestDTO subOrganizationIndexRequestDTO) {
        log.info(subOrganizationIndexRequestDTO.toString());
        SubOrganizationEndResponseDTO subOrganizationEndResponseDTO = subOrganizationService.registerSubOrganization(organizationCode, subOrganizationIndexRequestDTO);
        return subOrganizationEndResponseDTO;
    }

    @GetMapping(value = "/getall")
    public List<SubOrganizationResponseDTO> getAllSubOrganization(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size, @RequestParam(value = "column") String column) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(column));
        List<SubOrganizationResponseDTO> subOrganizationResponseDTOList = subOrganizationService.getAllSubOrganization(pageable);
        return subOrganizationResponseDTOList;
    }

    @PutMapping(value = "update")
    public SubOrganizationResponseDTO updateSubOrganization(@RequestParam(value = "subOrganizationCode") String subOrganizationCode, @Valid @RequestBody SubOrganizationUpdateRequestDTO subOrganizationUpdateRequestDTO) {
        SubOrganizationResponseDTO subOrganizationResponseDTO = subOrganizationService.updateSubOrganization(subOrganizationCode, subOrganizationUpdateRequestDTO);
        return subOrganizationResponseDTO;
    }

    @Transactional
    @DeleteMapping
    public ResponseEntity<?> deleteRecordBySubOrgCode(@RequestParam(value = "SubOrganizationCode") String SubOrganizationCode) {
        if (subOrganizationService.deleteRecordBySubOrgCode(SubOrganizationCode)) {
            ErrorResponse errorResponse = new ErrorResponse("CODE_606", "given record deleted successfully");
            log.info("-------------------------"+SubOrganizationCode+"-hard---delete---done-- successfully-----------------");
            return new ResponseEntity<>(errorResponse, HttpStatus.OK);
        } else {
            return null;

        }

    }

    @DeleteMapping(value = "deactivate")
    public ResponseEntity<?> statusOfSubOrg(@RequestParam(value = "subOrganizationCode") String subOrganizationCode, @RequestParam(value = "status") Status status) {
        if (subOrganizationService.statusOfSubOrg(subOrganizationCode, status)) {
            ErrorResponse errorResponse = new ErrorResponse("CODE_606", "given record deleted successfully");
            log.info("-------------------------"+subOrganizationCode+"-deactivated successfully-----------------");
            return new ResponseEntity<>(errorResponse, HttpStatus.OK);
        } else {
            return null;

        }
    }
}
