package org.baali.spring.hibernate.dao;

import java.util.List;

import org.baali.spring.hibernate.model.Employees;

public interface IEmployee
{
	public void save(Employees employee);

	public List<Employees> employeesList();
}
