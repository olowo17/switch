package org.interswitch.repository;

import org.interswitch.model.Salary;

import java.util.ArrayList;
import java.util.List;

public class SalaryRepository {

	private List<Salary> salaries = new ArrayList<>();
	
	public Salary add(Salary salary) {
		salary.setId((long) (salaries.size()+1));
		salaries.add(salary);
		return salary;
	}
	
	public Salary findById(Long id) {
		return salaries.stream()
				.filter(a -> a.getId().equals(id))
				.findFirst()
				.orElseThrow();
	}
	
	public List<Salary> findAll() {
		return salaries;
	}

	public List<Salary> getSalariesByEmployeeId(Long employeeId){
		return salaries.stream()
				.filter(a -> a.getEmployeeId().equals(employeeId))
				.toList();
	}
    public List<Salary> getAllSalaries() {
		return salaries;
    }
}
