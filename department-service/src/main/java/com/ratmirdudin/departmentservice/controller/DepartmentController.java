package com.ratmirdudin.departmentservice.controller;

import com.ratmirdudin.departmentservice.entity.Department;
import com.ratmirdudin.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment method id DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside findDepartmentById method id DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }
}
