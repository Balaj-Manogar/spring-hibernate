package org.baali.spring.hibernate.web.service;

import java.util.List;

import org.baali.spring.hibernate.model.Employees;
import org.baali.spring.hibernate.web.dao.IEmployeeDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements IEmployeeService
{
	private IEmployeeDAO employeeDAO;
	
	
	public void setEmployeeDAO(IEmployeeDAO employeeDAO)
	{
		this.employeeDAO = employeeDAO;
	}

	@Transactional
	public void addEmployee(Employees employee)
	{
		this.employeeDAO.addEmployee(employee);
	}

	@Transactional
	public void updateEmployee(Employees employee)
	{
		this.employeeDAO.updateEmployee(employee);

	}

	@Transactional
	public List<Employees> employeesList()
	{
		// TODO Auto-generated method stub
		return this.employeeDAO.employeesList();
	}

	@Transactional
	public Employees getEmployeeByNo(int empNo)
	{
		// TODO Auto-generated method stub
		return this.employeeDAO.getEmployeeByNo(empNo);
	}

	@Transactional
	public void removeEmployee(int empNo)
	{
		this.employeeDAO.removeEmployee(empNo);
	}

}
