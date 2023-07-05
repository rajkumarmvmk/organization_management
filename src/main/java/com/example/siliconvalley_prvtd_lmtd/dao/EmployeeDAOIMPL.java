package com.example.siliconvalley_prvtd_lmtd.dao;

import com.example.siliconvalley_prvtd_lmtd.entity.EmployeesEntity;
import com.example.siliconvalley_prvtd_lmtd.exception.CustomException;
import com.example.siliconvalley_prvtd_lmtd.exception.ErrorCodes;
import com.example.siliconvalley_prvtd_lmtd.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
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
            log.info("----------------------data not exists------------------------------------");
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
            log.info("----------------------data not exists------------------------------------");
            throw new CustomException(ErrorCodes.CODE_601.name(), ErrorCodes.CODE_601.getMessage());
        }
    }
    @Override
    public List<EmployeesEntity> getAll(){
        List<EmployeesEntity> employeesEntities=employeeRepository.findAll();
        return employeesEntities;
    }
    @Override
    public EmployeesEntity getTheRecord(String employeeCode){
        if(employeeRepository.existsByEmployeeCode(employeeCode)){
            EmployeesEntity employeesEntity=employeeRepository.findByEmployeeCode(employeeCode);
            return employeesEntity;
        }else{
            log.info("----------------------data not exists------------------------------------");
            throw new CustomException(ErrorCodes.CODE_602.name(),ErrorCodes.CODE_602.getMessage());
        }
    }
@Override
    public EmployeesEntity saveTheChange(EmployeesEntity employeesEntity){
        employeeRepository.save(employeesEntity);
        if(employeeRepository.existsByEmployeeCode(employeesEntity.getEmployeeCode())){
            EmployeesEntity employeesEntity1=employeeRepository.findByEmployeeCode(employeesEntity.getEmployeeCode());
            return employeesEntity1;
        }else{
            log.info("----------------------data not exists------------------------------------");
            throw new CustomException(ErrorCodes.CODE_602.name(),ErrorCodes.CODE_602.getMessage());
        }
}
    @Override
    public void deleteTheRecord(EmployeesEntity employeesEntity){
        try{
            employeeRepository.deleteByEmployeeCode(employeesEntity.getEmployeeCode());
        }catch (Exception e){
            log.info("----------------------delete moment error------------------------------------");
            throw  new CustomException(ErrorCodes.CODE_607.name(),ErrorCodes.CODE_607.getMessage());
        }
    }
    }

