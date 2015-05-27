package org.baali.spring.hibernate.dao;

import java.util.List;

import org.hibernate.Query;

import org.baali.spring.hibernate.model.Employees;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeService implements IEmployee
{
	private SessionFactory sessionFactory;
	private Session session;

	public void setSessionfactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
		
	}
	
	public void save(Employees employee)
	{
		this.session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(employee);
		tx.commit();
		session.close();

	}

	public List<Employees> employeesList()
	{
		this.session = sessionFactory.openSession();
		// Employees to be mapped with Employees class name not table name
		Query query = session.createQuery("from Employees");
		query.setMaxResults(10);
		List<Employees> employeesList = query.list();
		return employeesList;
	}

}
