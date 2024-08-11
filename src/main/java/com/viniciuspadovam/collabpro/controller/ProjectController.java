package com.viniciuspadovam.collabpro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viniciuspadovam.collabpro.domain.project.CreateProjectDto;
import com.viniciuspadovam.collabpro.domain.project.Project;
import com.viniciuspadovam.collabpro.domain.project.UpdateProjectDto;
import com.viniciuspadovam.collabpro.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/list")
    public ResponseEntity<List<Project>> list() {
        return ResponseEntity.ok(projectService.list());
    }

    @GetMapping("/get")
    public ResponseEntity<Project> get(@RequestParam(name = "id") String id) {
        Optional<Project> project = projectService.get(id);
        if(project.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(project.get());
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<Project> create(@RequestBody @Valid CreateProjectDto data) {
        Project newProject = new Project(data);
        
        return ResponseEntity.status(201).body(projectService.create(newProject));
    }
    
    @PutMapping
    @Transactional
    public ResponseEntity<String> update(@RequestBody @Valid UpdateProjectDto data) {
        int rowsAffected = projectService.update(data);

        if(rowsAffected > 0) {
            return ResponseEntity.ok("Update successful.");
        }

        return ResponseEntity.ok("No register updated.");
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam(name = "id") String id) {
        int deletedProject = projectService.delete(id);

        if(deletedProject == 1) {
            return ResponseEntity.ok("No register deleted.");
        }

        return ResponseEntity.ok("Deleted successfuly");
    }

}
