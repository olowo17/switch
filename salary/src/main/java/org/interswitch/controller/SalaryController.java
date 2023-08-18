package org.interswitch.controller;

import org.interswitch.client.DepartmentClient;
import org.interswitch.model.Department;
import org.interswitch.model.Employee;
import org.interswitch.model.Salary;
import org.interswitch.repository.SalaryRepository;
import org.interswitch.service.SalaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.interswitch.client.EmployeeClient;

import java.util.List;

@RestController
public class SalaryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SalaryController.class);

	@Autowired
	SalaryRepository repository;
	@Autowired
	SalaryService salaryService;
	@Autowired
	private EmployeeClient employeeClient;
	@Autowired
	private DepartmentClient departmentClient;

	@PostMapping("/")
	public Salary add(@RequestBody Salary salary) {
		LOGGER.info("Salary add: {}", salary);
		return repository.add(salary);
	}
	@GetMapping("/")
	public List<Salary> getAll(){
		return repository.getAllSalaries();
	}
	@GetMapping("/salary/{employeeId}")
	public List<Salary> getSalariesByEmployeeId(@PathVariable("employeeId") Long employeeId) {
		LOGGER.info("Salary find: employeeId={}", employeeId);
		Employee byEmployeeId = employeeClient.findByEmployeeId(employeeId);
		return salaryService.getSalaryByEmployeeId(byEmployeeId.getId());
	}

	@PatchMapping("/salary-update/{employeeId}/{departmentId}")
	public void addEmployeeIDToSalary(@PathVariable Long employeeId, @PathVariable Long departmentId){

		Department department = departmentClient.findById(departmentId);

		Employee byEmployeeId = employeeClient.findByEmployeeId(employeeId);

		salaryService.addDepartmentIdToSalary(department.getId(),byEmployeeId.getId());

	}
}
