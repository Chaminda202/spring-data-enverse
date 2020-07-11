package com.spring.data.enverse.service;


import com.spring.data.enverse.model.EmployeeDTO;
import com.spring.data.enverse.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO save(Employee employee);
    EmployeeDTO update(Employee employee);
    void delete(Integer empId);
    List<EmployeeDTO> findAll();
    EmployeeDTO findById(Integer empId);
}
