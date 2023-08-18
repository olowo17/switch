package com.interswitch.services.taskservice.repository;

import com.interswitch.services.taskservice.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private List<Task> tasks = new ArrayList<>();

    public Task add(Task task) {
        task.setId((long) (tasks.size()+1));
        tasks.add(task);
        return task;
    }

    public Task findById(Long id) {
        return tasks.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Task> findAll() {
        return tasks;
    }

    public List<Task> findByEmployeeId(Long employeeId) {
        return tasks.stream()
                .filter(a -> a.getIsAssignedTo().equals(employeeId))
                .toList();
    }
}
