package com.example.siliconvalley_prvtd_lmtd.controller;

import com.example.siliconvalley_prvtd_lmtd.exception.ErrorResponse;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.EmployeesRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.EmployeesUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ProjectsUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.EmployeesResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ProjectsResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/register/org/{organizationCode}")
    public List<EmployeesResponseDTO> registerEmpToOrg(@RequestBody @Valid List<EmployeesRequestDTO> employeesRequestDTOS,String organizationCode){
       List<EmployeesResponseDTO> employeesResponseDTOS = employeeService.registerEmpOrg(employeesRequestDTOS,organizationCode);
       return employeesResponseDTOS;

    }
    @PostMapping("/register/subOrg/{subOrganizationCode}")
    public List<EmployeesResponseDTO> registerEmpToSubOrg(@RequestBody @Valid List<EmployeesRequestDTO> employeesRequestDTOS,String subOrganizationCode){
        List<EmployeesResponseDTO> employeesResponseDTOS = employeeService.registerEmpSubOrg(employeesRequestDTOS,subOrganizationCode);
        return employeesResponseDTOS;

    }
    @GetMapping("/Getall")
    public List<EmployeesResponseDTO> getAll() {
        List<EmployeesResponseDTO> employeesResponseDTOS = employeeService.getAll();
        return employeesResponseDTOS;
    }
    @PutMapping(value="/update/{employeeCode}")
    public EmployeesResponseDTO updateEmployee(@RequestBody @Valid EmployeesUpdateRequestDTO employeesUpdateRequestDTO, @PathVariable(value="employeeCode") String employeeCode){
        EmployeesResponseDTO employeesResponseDTO=employeeService.updateEmployee(employeesUpdateRequestDTO,employeeCode);
        return employeesResponseDTO;
    }
    @DeleteMapping(value = "/{employeeCode}")
    public ResponseEntity<?> deleteRecordByEmployeeCode(@PathVariable(value = "employeeCode") String employeeCode) {
        if (employeeService.deleteRecordByEmployeeCode(employeeCode)) {
            ErrorResponse errorResponse = new ErrorResponse("CODE_606", "given record deleted successfully");

            return new ResponseEntity<>(errorResponse, HttpStatus.OK);
        } else {
            return null;

        }
    }

}
