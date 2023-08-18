package com.interswitch.services.taskservice.controller;

import com.interswitch.services.taskservice.client.EmployeeClient;
import com.interswitch.services.taskservice.model.Employee;
import com.interswitch.services.taskservice.model.Task;
import com.interswitch.services.taskservice.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);


    @Autowired
    TaskRepository taskRepository;
    @Autowired
    EmployeeClient employeeClient;


    @PostMapping("/")
    public Task add(@RequestBody Task task) {
        LOGGER.info("Task add: {}", task);
        return taskRepository.add(task);
    }

    @GetMapping("/")
    public List<Task> findAll() {
        LOGGER.info("Task find");
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable("id") Long id) {
        LOGGER.info("Task find: id={}", id);
        return taskRepository.findById(id);
    }


    @GetMapping("/task/{employeeId}")
    public List<Task> findTasksByEmployeeId(@PathVariable("employeeId") Long employeeId) {
        LOGGER.info("Task find: id={}", employeeId);
        Employee employee = employeeClient.findEmployee(employeeId);
        return taskRepository.findByEmployeeId(employee.getId());
    }
}
