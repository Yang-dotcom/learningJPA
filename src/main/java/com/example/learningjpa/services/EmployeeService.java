//package com.example.learningjpa.services;
//
//import com.example.learningjpa.dto.EmployeeDTO;
//import com.example.learningjpa.entity.Employee;
//import com.example.learningjpa.mapper.EmployeeMapper;
//import com.example.learningjpa.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmployeeService {
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
//        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
//        employeeRepository.save(employee);
//        return employeeDTO;
//    }
//}
