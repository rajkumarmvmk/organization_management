package com.example.siliconvalley_prvtd_lmtd.repository;

import com.example.siliconvalley_prvtd_lmtd.entity.EmployeesEntity;
import com.example.siliconvalley_prvtd_lmtd.entity.ProjectsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeesEntity,String> {
    boolean existsByEmployeeCode(String employeeCode);
    EmployeesEntity findByEmployeeCode(String employeeCode);
}
