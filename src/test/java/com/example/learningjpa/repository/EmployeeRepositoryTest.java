package com.example.learningjpa.repository;

import com.example.learningjpa.entity.Employee;
import com.example.learningjpa.entity.Registry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
ddd
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void saveEmployee(){
        Employee employee = Employee.builder()
//                .name("Roger")
//                .firstName("Brown")
//                .age(43)
//                .gender("M")
//                .date_birth(Date.valueOf(LocalDate.now()))
                .job("officer worker")
                .build();
        employeeRepository.save(employee);
    }

    @Test
    public void printAllStudent(){
        List<Employee> employees = employeeRepository.findAll();
        System.out.println("employees: " + employees);
    }

    @Test
    public void saveEmployeeWithRegistry(){
        Registry registry = Registry.builder()
                .registryName("Michael")
               .registryFirstName("Sin")
               .age(33)
                .gender("M")
                .date_birth(Date.valueOf(LocalDate.now()))
                .build();

        Employee employee = Employee.builder()
                .job("blue collar")
                .registry(registry)
                .build();
        employeeRepository.save(employee);
    }

    @Test
    public void printEmployeeByJob(){
        List<Employee> employees = employeeRepository.findByJob("blue collar");
        System.out.println(employees);
    }
    @Test
    public void printEmployeeByAge(){
        List<Employee> employees = employeeRepository.findByRegistryAge(33);
        System.out.println(employees);
    }

    @Test
    public void printEmployeeByName(){
        List<Employee> employees = employeeRepository.findByRegistryRegistryName("Sin ");
        System.out.println(employees);
    }
    @Test
    public void printEmployeeByJobContaining(){
        List<Employee> employees = employeeRepository.findByJobContaining("blue");
        System.out.println(employees);
    }

    @Test
    public void printEmployeeByJob2(){
        Employee employee = employeeRepository.getEmployeeByJob("blue collar");
        System.out.println(employee);
    }

    @Test
    public void printEmployeeByJob3(){
        Employee employee = employeeRepository.getEmployeeByJob3("blue collar");
        System.out.println(employee);
    }

    @Test
    public void printEmployeeByJob4(){
        Employee employee = employeeRepository.getEmployeeByJob4("blue collar");
        System.out.println(employee);
    }

    @Test
    public void updateEmployeeFirstNameByJob(){
        employeeRepository.updateEmployeeByJob(
                "John",
                "blue collar"
        );
    }


}