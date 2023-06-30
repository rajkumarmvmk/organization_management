package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.EmployeesEntity;
import com.example.siliconvalley_prvtd_lmtd.exception.CustomException;
import com.example.siliconvalley_prvtd_lmtd.exception.ErrorCodes;
import com.example.siliconvalley_prvtd_lmtd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDAOIMPL implements EmployeeDAO {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeesEntity registerEmpOrg(EmployeesEntity employeesEntity) {
        employeeRepository.save(employeesEntity);

        if (employeeRepository.existsByEmployeeCode(employeesEntity.getEmployeeCode())) {
            EmployeesEntity employeesEntity1 = employeeRepository.findByEmployeeCode(employeesEntity.getEmployeeCode());
            return employeesEntity1;
        } else {
            throw new CustomException(ErrorCodes.CODE_601.name(), ErrorCodes.CODE_601.getMessage());
        }
    }
    @Override
    public EmployeesEntity registerEmpSubOrg(EmployeesEntity employeesEntity) {
        employeeRepository.save(employeesEntity);

        if (employeeRepository.existsByEmployeeCode(employeesEntity.getEmployeeCode())) {
            EmployeesEntity employeesEntity1 = employeeRepository.findByEmployeeCode(employeesEntity.getEmployeeCode());
            return employeesEntity1;
        } else {
            throw new CustomException(ErrorCodes.CODE_601.name(), ErrorCodes.CODE_601.getMessage());
        }
    }
    }

