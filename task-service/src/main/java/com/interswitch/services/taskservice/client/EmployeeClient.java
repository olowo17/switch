package com.interswitch.services.taskservice.client;

import com.interswitch.services.taskservice.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "employee-service")
public interface EmployeeClient {
        @GetMapping("/{employeeId}")
        Employee findEmployee(@PathVariable("employeeId") Long employeeId);
}
