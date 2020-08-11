package com.ste.easytaks.api.service;

import com.ste.easytaks.api.enums.TaskStatus;
import com.ste.easytaks.api.model.Task;
import com.ste.easytaks.api.repository.TaskRepository;
import com.ste.easytaks.api.validate.TaskValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @ResponseStatus(HttpStatus.OK)
    public List<Task> findAll() {
        List<Task> tasks = taskRepository.findAll();
        TaskValidate.tasksNotFoundMessage(tasks);
        return tasks;
    }

    @ResponseStatus(HttpStatus.CREATED)
    public Task create(Task task) {
        task.setUpdateDate(LocalDate.now());

        if (StringUtils.isEmpty(task.getTaskStatus())) {
            task.setTaskStatus(TaskStatus.TO_DO);
        }

        return taskRepository.save(task);
    }

    @ResponseStatus(HttpStatus.OK)
    public Task findById(String id) {
        Task task = taskRepository.findById(id).orElse(null);
        TaskValidate.taskNotFoundMessage(task);
        return task;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public List<Task> findByDescription(String description) {
        List<Task> tasks = taskRepository.findByDescriptionLikeIgnoreCase(description);
        TaskValidate.tasksNotFoundMessage(tasks);
        return taskRepository.findByDescriptionLikeIgnoreCase(description);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Task update(String id, Task task) {
        Task taskToUpdate = taskRepository.findById(id).orElse(null);
        task.setId(id);
        task.setUpdateDate(LocalDate.now());
        return taskRepository.save(taskToUpdate);
    }

    public void deleteById(String id) {
        taskRepository.deleteById(id);
    }
}
