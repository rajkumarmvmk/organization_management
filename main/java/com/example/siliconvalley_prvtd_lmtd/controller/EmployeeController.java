package com.example.siliconvalley_prvtd_lmtd.controller;

import com.example.siliconvalley_prvtd_lmtd.requestDTO.EmployeesRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.EmployeesResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
