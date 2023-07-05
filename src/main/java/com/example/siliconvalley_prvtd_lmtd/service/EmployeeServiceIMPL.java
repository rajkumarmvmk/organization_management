package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.dao.EmployeeDAO;
import com.example.siliconvalley_prvtd_lmtd.dao.OrganizationDAO;
import com.example.siliconvalley_prvtd_lmtd.dao.SubOrganizationDAO;
import com.example.siliconvalley_prvtd_lmtd.entity.*;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.EmployeesRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.EmployeesUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.EmployeesResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ProjectsResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceIMPL implements EmployeeService{
    @Autowired
    private SubOrganizationDAO subOrganizationDAO;
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private OrganizationDAO organizationDAO;
    @Override
    public List<EmployeesResponseDTO> registerEmpOrg(List<EmployeesRequestDTO> employeesRequestDTOS,String organizationCode){
        OrganizationEntity organizationEntity = organizationDAO.fetchRecord(organizationCode);
        List<EmployeesResponseDTO> employeesResponseDTOS =new ArrayList<>();
        employeesRequestDTOS.stream().forEach(list ->{
            EmployeesEntity employeesEntity=new EmployeesEntity();
            EmployeesResponseDTO employeesResponseDTO=new EmployeesResponseDTO();
            BeanUtils.copyProperties(list,employeesEntity);
            employeesEntity.setOrganizationEntity(organizationEntity);
            EmployeesEntity employeesEntity1=employeeDAO.registerEmpOrg(employeesEntity);
            BeanUtils.copyProperties(employeesEntity1,employeesResponseDTO);
            employeesResponseDTOS.add(employeesResponseDTO);
        });
        return employeesResponseDTOS;
    }
    @Override
    public List<EmployeesResponseDTO> registerEmpSubOrg(List<EmployeesRequestDTO> employeesRequestDTOS,String subOrganizationCode){

        SubOrganizationEntity subOrganizationEntity=subOrganizationDAO.getBySubOrgCode(subOrganizationCode);
        List<EmployeesResponseDTO> employeesResponseDTOS =new ArrayList<>();
        employeesRequestDTOS.stream().forEach(list ->{
            EmployeesEntity employeesEntity=new EmployeesEntity();
            EmployeesResponseDTO employeesResponseDTO=new EmployeesResponseDTO();
            BeanUtils.copyProperties(list,employeesEntity);
            employeesEntity.setSubOrganizationEntity(subOrganizationEntity);
            EmployeesEntity employeesEntity1=employeeDAO.registerEmpSubOrg(employeesEntity);
            BeanUtils.copyProperties(employeesEntity1,employeesResponseDTO);
            employeesResponseDTOS.add(employeesResponseDTO);
        });
        return employeesResponseDTOS;
    }
    @Override
    public List<EmployeesResponseDTO> getAll(){
        List<EmployeesEntity> employeesEntities = employeeDAO.getAll();
        List<EmployeesResponseDTO> employeesResponseDTOS=new ArrayList<>();

        employeesEntities.stream().forEach(list->{
            EmployeesResponseDTO employeesResponseDTO = new EmployeesResponseDTO();
            BeanUtils.copyProperties(list,employeesResponseDTO);
            employeesResponseDTOS.add(employeesResponseDTO);
        });
        return employeesResponseDTOS;
    }
    @Override
    public EmployeesResponseDTO updateEmployee(EmployeesUpdateRequestDTO employeesUpdateRequestDTO, String employeeCode){
        EmployeesEntity employeesEntity=employeeDAO.getTheRecord(employeeCode);
        BeanUtils.copyProperties(employeesUpdateRequestDTO,employeesEntity);
        EmployeesEntity employeesEntity1=employeeDAO.saveTheChange(employeesEntity);
        EmployeesResponseDTO employeesResponseDTO=new EmployeesResponseDTO();
        BeanUtils.copyProperties(employeesEntity1,employeesResponseDTO);
        return employeesResponseDTO;
    }
    @Override
    public  boolean deleteRecordByEmployeeCode(String employeeCode){
        EmployeesEntity employeesEntity=employeeDAO.getTheRecord(employeeCode);
        employeesEntity.setSubOrganizationEntity(null);
        employeesEntity.setOrganizationEntity(null);
        employeeDAO.deleteTheRecord(employeesEntity);
        return true;
    }
}
