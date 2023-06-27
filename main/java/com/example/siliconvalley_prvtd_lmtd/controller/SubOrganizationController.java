package com.example.siliconvalley_prvtd_lmtd.controller;

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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("api/v1/suborganization")
public class SubOrganizationController {
    @Autowired
    private SubOrganizationService subOrganizationService;
    @PostMapping(value = "regsiter/{id}")
    public SubOrganizationEndResponseDTO register(@PathVariable(value="id") String regId, @Valid @RequestBody SubOrganizationIndexRequestDTO subOrganizationIndexRequestDTO){
        log.info(subOrganizationIndexRequestDTO.toString());
        SubOrganizationEndResponseDTO subOrganizationEndResponseDTO =subOrganizationService.register(regId,subOrganizationIndexRequestDTO);
        return subOrganizationEndResponseDTO;
    }
    @GetMapping(value="/getall/{page}/{size}/{column}")
    public List<SubOrganizationResponseDTO> getAllOrganization(@PathVariable (value = "page") int page, @PathVariable(value = "size") int size,@PathVariable(value="column") String column){
        Pageable pageable = PageRequest.of(page,size, Sort.by(column));
        List<SubOrganizationResponseDTO> subOrganizationResponseDTOList=subOrganizationService.getAllSubOrganization(pageable);
        return subOrganizationResponseDTOList;
    }
    @PutMapping(value = "update/{id}")
    public SubOrganizationResponseDTO updateSubOrganization(@PathVariable(value = "id") String organizationId , @Valid @RequestBody SubOrganizationUpdateRequestDTO subOrganizationUpdateRequestDTO){
     SubOrganizationResponseDTO subOrganizationResponseDTO=subOrganizationService.updateOrganization(organizationId,subOrganizationUpdateRequestDTO);
      return subOrganizationResponseDTO;
    }
    @Transactional
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteRecordById(@PathVariable(value="id") String organizationId){
        if(subOrganizationService.deleteRecordById(organizationId)){
            ErrorResponse errorResponse = new ErrorResponse("CODE_606","given record deleted successfully");

            return new ResponseEntity<>(errorResponse, HttpStatus.OK);
        }else{
            return null;

        }

    }
}
