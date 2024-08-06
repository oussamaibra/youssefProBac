package com.example.Task_Management.controllers.employee;

import com.example.Task_Management.dto.ProjectDTO;
import com.example.Task_Management.dto.UserDtoUpdate;
import com.example.Task_Management.entities.Task;
import com.example.Task_Management.entities.User;
import com.example.Task_Management.services.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDTO>> getProjectsByUserId() {
       return ResponseEntity.ok(employeeService.getProjectsByUserId());
    }

    @GetMapping("/id")
    public ResponseEntity<User> getUserById() {
        return ResponseEntity.ok(employeeService.getUserById());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> UpdateUserById(@RequestBody UserDtoUpdate user) {
        return ResponseEntity.ok(employeeService.UpdateUserById(user));
    }

}
