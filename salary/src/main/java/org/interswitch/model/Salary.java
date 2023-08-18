package org.interswitch.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Salary {

	private Long id;
	private Long employeeId;
	private BigDecimal amount;
	private LocalDate date;
	private Long departmentId;

	public Salary() {
	}

	public Salary(Long employeeId, BigDecimal amount, LocalDate date) {
		this.employeeId = employeeId;
		this.amount = amount;
		this.date = date;
	}

	public Salary(Long id, Long employeeId, BigDecimal amount, LocalDate date, Long departmentId) {
		this.id = id;
		this.employeeId = employeeId;
		this.amount = amount;
		this.date = date;
		this.departmentId = departmentId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
