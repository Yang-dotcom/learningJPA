//package com.example.learningjpa.mapper;
//
//import com.example.learningjpa.dto.EmployeeDTO;
//import com.example.learningjpa.entity.Employee;
//
//public class EmployeeMapper {
//    public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
//        return new EmployeeDTO(
//                employee.getEmployeeId(),
//                employee.getName(),
//                employee.getFirstName(),
//                employee.getJob()
//        );
//    }
//    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
//        return new Employee(
//                employeeDTO.getId(),
//                employeeDTO.getName(),
//                employeeDTO.getFirstNames(),
//                null, null, null,
//                employeeDTO.getJob()
//
//        );
//    }
//}
