package com.ste.easytaks.api.controller;

import com.ste.easytaks.api.model.Task;
import com.ste.easytaks.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getAll() {
        return taskService.findAll();
    }

    @PostMapping("/task")
    public Task create(@RequestBody Task task) {
        return taskService.create(task);
    }

    @GetMapping("task/{id}")
    public Task findById(@PathVariable String id) {
        return taskService.findById(id);
    }

    @GetMapping("/tasks/description/{description}")
    public List<Task> findByDescription(@PathVariable String description) {
        return taskService.findByDescription(description);
    }

    @PutMapping("/task/{id}")
    public Task update(@PathVariable String id, @RequestBody Task task) {
        return taskService.update(id, task);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable String id) {
        taskService.deleteById(id);
    }

}
