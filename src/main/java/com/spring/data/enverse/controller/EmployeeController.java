package com.spring.data.enverse.controller;

import com.spring.data.enverse.mapper.EmployeeMapper;
import com.spring.data.enverse.model.EmployeeDTO;
import com.spring.data.enverse.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "employees")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> save(@Valid @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO response = this.employeeService.save(EmployeeMapper.mapToEntity(employeeDTO));
        return ResponseEntity.ok().body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable(value = "id") @NotNull Integer empId,  @Valid @RequestBody EmployeeDTO employeeDTO) {
        employeeDTO.setId(empId);
        EmployeeDTO response = this.employeeService.update(EmployeeMapper.mapToEntity(employeeDTO));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll(){
        List<EmployeeDTO> response = this.employeeService.findAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable(value = "id") @NotNull Integer empId) {
        EmployeeDTO response = this.employeeService.findById(empId);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") @NotNull Integer empId) {
        this.employeeService.delete(empId);
        return ResponseEntity.noContent().build();
    }
}
