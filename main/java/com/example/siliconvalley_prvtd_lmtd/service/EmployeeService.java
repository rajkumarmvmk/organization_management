package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.requestDTO.EmployeesRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.EmployeesResponseDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeesResponseDTO> registerEmpOrg(List<EmployeesRequestDTO> employeesRequestDTOS, String organizationCode);
    List<EmployeesResponseDTO> registerEmpSubOrg(List<EmployeesRequestDTO> employeesRequestDTOS, String subOrganizationCode);
}
