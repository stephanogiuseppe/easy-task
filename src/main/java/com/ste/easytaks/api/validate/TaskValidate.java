package com.ste.easytaks.api.validate;

import com.ste.easytaks.api.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class TaskValidate {

    protected static final String MSG_TASK_NOT_FOUND = "Task not found";
    protected static final String MSG_TASKS_NOT_FOUND = "Tasks not found";

    public static void tasksNotFoundMessage(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, MSG_TASKS_NOT_FOUND);
        }
    }

    public static void taskNotFoundMessage(Task task) {
        if (task == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, MSG_TASK_NOT_FOUND);
        }
    }

}
