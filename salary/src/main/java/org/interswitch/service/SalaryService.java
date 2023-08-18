package org.interswitch.service;

import org.interswitch.model.Salary;
import org.interswitch.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SalaryService {

    @Autowired
    SalaryRepository repository;

    public SalaryService(SalaryRepository salaryRepository){
        this.repository = salaryRepository;
    }

    private List<Salary> salaries = new ArrayList<>();

    public List<Salary> getAllSalaries(){return repository.getAllSalaries();}

    public List<Salary> getSalaryByEmployeeId(Long employeeId){
        return repository.getSalariesByEmployeeId(employeeId);
    }

    public void addDepartmentIdToSalary(Long departmentId, Long employeeId) {
        List<Salary> salaryByEmployeeId = repository.getSalariesByEmployeeId(employeeId);

        for (Salary salary : salaryByEmployeeId) {
            salary.setDepartmentId(departmentId);
        }

    }
}
