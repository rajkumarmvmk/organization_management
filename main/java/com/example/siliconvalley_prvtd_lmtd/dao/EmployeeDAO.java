package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.ClientEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.EmployeesEntity;

import java.util.List;

public interface EmployeeDAO {
    EmployeesEntity registerEmpOrg(EmployeesEntity employeesEntity);
    EmployeesEntity registerEmpSubOrg(EmployeesEntity employeesEntity);
    public List<EmployeesEntity> getAll();
    EmployeesEntity getTheRecord(String employeeCode);
    EmployeesEntity saveTheChange(EmployeesEntity employeesEntity);
    void deleteTheRecord(EmployeesEntity employeesEntity);
}
