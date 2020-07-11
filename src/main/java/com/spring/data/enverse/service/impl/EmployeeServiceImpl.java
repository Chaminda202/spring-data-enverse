package com.spring.data.enverse.service.impl;

import com.spring.data.enverse.exception.EmployeeNotFoundException;
import com.spring.data.enverse.mapper.EmployeeMapper;
import com.spring.data.enverse.model.EmployeeDTO;
import com.spring.data.enverse.model.entity.Employee;
import com.spring.data.enverse.repository.EmployeeRepository;
import com.spring.data.enverse.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final MessageSource messageSource;

    @Override
    public EmployeeDTO save(Employee employee) {
        return EmployeeMapper.mapToDTO(this.employeeRepository
                .save(employee));
    }

    @Override
    public EmployeeDTO update(Employee employee) {
        Optional<Employee> employeeOptional = this.employeeRepository
                .findById(employee.getId());
        if(employeeOptional.isPresent()){
            return EmployeeMapper.mapToDTO(this.employeeRepository
                    .save(employee));
        }
        throw new EmployeeNotFoundException(
                this.messageSource.getMessage("employee.notfound", new Integer[]{employee.getId()}, Locale.ENGLISH));
    }

    @Override
    public void delete(Integer empId) {
        Optional<Employee> employeeOptional = this.employeeRepository
                .findById(empId);
        if(employeeOptional.isPresent()){
            this.employeeRepository.deleteById(empId);
        }
        throw new EmployeeNotFoundException(
                this.messageSource.getMessage("employee.notfound", new Integer[]{empId}, Locale.ENGLISH));
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return this.employeeRepository
                .findAll()
                .stream()
                .map(EmployeeMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findById(Integer empId) {
        return this.employeeRepository
                .findById(empId)
                .map(EmployeeMapper::mapToDTO)
                .orElseThrow(() ->new EmployeeNotFoundException(
                        this.messageSource.getMessage("employee.notfound", new Integer[]{empId}, Locale.ENGLISH)
                ));
    }
}
