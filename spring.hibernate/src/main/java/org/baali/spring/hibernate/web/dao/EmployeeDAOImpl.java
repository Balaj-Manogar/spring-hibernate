package org.baali.spring.hibernate.web.dao;

import java.util.List;

import org.baali.spring.hibernate.model.Employees;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeDAOImpl implements IEmployeeDAO
{
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public void addEmployee(Employees employee)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(employee);
		logger.info("Employee added: " + employee.getEmployeeNumber() );

	}

	public void updateEmployee(Employees employee)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.update(employee);
		logger.info("Employee updated: " + employee.getEmployeeNumber() );
	}

	public List<Employees> employeesList()
	{
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employees");
		query.setMaxResults(10);
		List<Employees> employeesList = query.list();
		for(Employees e : employeesList)
		{
			logger.info("Employee List :" + e.getEmployeeNumber());
		}
		return employeesList;
	}

	public Employees getEmployeeByNo(int empNo)
	{
		Session session = this.sessionFactory.getCurrentSession();
		Employees employee = (Employees) session.get(Employees.class, empNo);
		logger.info("Employee By Id: " + employee.getEmployeeNumber() );
		return employee;
	}

	public void removeEmployee(int empNo)
	{
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete Employees where employeeNumber = :eno");
		query.setParameter("eno", empNo);
		
		int result = query.executeUpdate();
		logger.info("Employee Deleted: " + empNo + " Result id:" + result);		

	}

}

