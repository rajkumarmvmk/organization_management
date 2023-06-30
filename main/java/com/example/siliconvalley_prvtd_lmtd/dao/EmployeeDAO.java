package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.EmployeesEntity;

public interface EmployeeDAO {
    EmployeesEntity registerEmpOrg(EmployeesEntity employeesEntity);
    EmployeesEntity registerEmpSubOrg(EmployeesEntity employeesEntity);
}
