package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.requestDTO.EmployeesRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.EmployeesUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ProjectsUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.EmployeesResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ProjectsResponseDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeesResponseDTO> registerEmpOrg(List<EmployeesRequestDTO> employeesRequestDTOS, String organizationCode);
    List<EmployeesResponseDTO> registerEmpSubOrg(List<EmployeesRequestDTO> employeesRequestDTOS, String subOrganizationCode);
    List<EmployeesResponseDTO> getAll();
    EmployeesResponseDTO updateEmployee(EmployeesUpdateRequestDTO employeesUpdateRequestDTO,String employeeCode);
    boolean deleteRecordByEmployeeCode(String employeeCode);
}
