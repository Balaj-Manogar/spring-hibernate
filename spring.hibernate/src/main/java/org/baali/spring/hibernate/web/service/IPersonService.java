package org.baali.spring.hibernate.web.service;

import java.util.List;

import org.baali.spring.hibernate.model.Employees;

public interface IPersonService
{
	public void addEmployee(Employees employee);
	public void updateEmployee(Employees employee);
	public List<Employees> employeesList();
	public Employees getEmployeeByNo(int empNo);
	public void removeEmployee(int empNo);
}
