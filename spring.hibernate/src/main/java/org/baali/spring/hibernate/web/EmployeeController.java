package org.baali.spring.hibernate.web;

import org.baali.spring.hibernate.web.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController
{
	@Autowired
	@Qualifier(value="employeeService")
	private IEmployeeService employeeService;

	public void setEmployeeService(IEmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}
	
	@RequestMapping(value="/list")
	public String listEmployees(Model m)
	{
		m.addAttribute("presentationType", "list");
		m.addAttribute("employeeList", this.employeeService.employeesList());
		return "list";
	}

}
