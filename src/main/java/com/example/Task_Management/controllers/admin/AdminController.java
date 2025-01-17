package com.example.Task_Management.controllers.admin;

import com.example.Task_Management.dto.CommentDTO;
import com.example.Task_Management.dto.ProjectDTO;
import com.example.Task_Management.services.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/users")
    public ResponseEntity<?> getUsers(){

        return ResponseEntity.ok(adminService.getUsers());
    }

    @PostMapping("/project")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO){
        ProjectDTO createdProjectDto = adminService.createProject(projectDTO);
        if(createdProjectDto == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProjectDto);
    }

    @GetMapping("/projects")
    public ResponseEntity<?> getAllProjects(){

        return ResponseEntity.ok(adminService.getAllProjects());
    }

    @DeleteMapping("/project/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
            adminService.deleteProject(id);
            return ResponseEntity.ok(null);
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getProjectById(id));
    }

    @PutMapping("/project/{id}")
    public ResponseEntity<?> updateProject(@PathVariable Long id, @RequestBody ProjectDTO projectDTO){
        ProjectDTO updatedProject =adminService.updateProject(id, projectDTO);
        if (updatedProject == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedProject);
    }

    @GetMapping("/projects/search/{title}")
    public ResponseEntity<List<ProjectDTO>> searchProject(@PathVariable String title){
        return ResponseEntity.ok(adminService.searchProjectByTitle(title));

    }

    @PostMapping("/project/comment/{projectId}")
    public ResponseEntity<CommentDTO> createComment(@PathVariable Long projectId, @RequestParam String content){
        CommentDTO createdCommentDTO = adminService.createComment(projectId,content);
        if(createdCommentDTO == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCommentDTO);
    }

    @GetMapping("/comments/{projectId}")
    public ResponseEntity<List<CommentDTO>> getCommentsByProjectId(@PathVariable Long projectId){
        return ResponseEntity.ok(adminService.getCommentsByProjectId(projectId));
    }
}
