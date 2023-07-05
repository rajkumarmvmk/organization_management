package com.example.siliconvalley_prvtd_lmtd.controller;

import com.example.siliconvalley_prvtd_lmtd.exception.ErrorResponse;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.EmployeesRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.EmployeesUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ProjectsUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.EmployeesResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ProjectsResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/register/org")
    public List<EmployeesResponseDTO> registerEmpToOrg(@RequestBody @Valid List<EmployeesRequestDTO> employeesRequestDTOS,@RequestParam(value = "organizationCode") String organizationCode){
       List<EmployeesResponseDTO> employeesResponseDTOS = employeeService.registerEmpOrg(employeesRequestDTOS,organizationCode);
       return employeesResponseDTOS;

    }
    @PostMapping("/register/subOrg")
    public List<EmployeesResponseDTO> registerEmpToSubOrg(@RequestBody @Valid List<EmployeesRequestDTO> employeesRequestDTOS,@RequestParam(value="subOrganizationCode") String subOrganizationCode){
        List<EmployeesResponseDTO> employeesResponseDTOS = employeeService.registerEmpSubOrg(employeesRequestDTOS,subOrganizationCode);
        return employeesResponseDTOS;

    }
    @GetMapping("/Getall")
    public List<EmployeesResponseDTO> getAll() {
        List<EmployeesResponseDTO> employeesResponseDTOS = employeeService.getAll();
        return employeesResponseDTOS;
    }
    @PutMapping(value="/update")
    public EmployeesResponseDTO updateEmployee(@RequestBody @Valid EmployeesUpdateRequestDTO employeesUpdateRequestDTO, @RequestParam(value="employeeCode") String employeeCode){
        EmployeesResponseDTO employeesResponseDTO=employeeService.updateEmployee(employeesUpdateRequestDTO,employeeCode);
        return employeesResponseDTO;
    }
    @DeleteMapping
    public ResponseEntity<?> deleteRecordByEmployeeCode(@RequestParam(value = "employeeCode") String employeeCode) {
        if (employeeService.deleteRecordByEmployeeCode(employeeCode)) {
            ErrorResponse errorResponse = new ErrorResponse("CODE_606", "given record deleted successfully");
            log.info("-------------------------"+employeeCode+"-deleted successfully-----------------");
            return new ResponseEntity<>(errorResponse, HttpStatus.OK);
        } else {
            return null;

        }
    }

}
