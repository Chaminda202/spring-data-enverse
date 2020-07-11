package com.spring.data.enverse.repository;

import com.spring.data.enverse.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends RevisionRepository<Employee, Integer, Integer>, JpaRepository<Employee, Integer> {
}
