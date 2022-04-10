package com.ratmirdudin.departmentservice.service;

import com.ratmirdudin.departmentservice.entity.Department;
import com.ratmirdudin.departmentservice.exception.ResourceNotFoundException;
import com.ratmirdudin.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment method of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentService");
        return departmentRepository.findById(departmentId).orElseThrow(
                ()-> new ResourceNotFoundException("Resource with id: " + departmentId + " not found")
        );
    }
}
