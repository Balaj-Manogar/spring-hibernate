package spring.hibernate.test;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.baali.spring.hibernate.dao.EmployeeService;
import org.baali.spring.hibernate.dao.IEmployee;
import org.baali.spring.hibernate.model.Employees;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConsoleTest
{

	public static void main(String[] args) throws ParseException
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		IEmployee employeeService = (IEmployee) applicationContext.getBean("employeeService");
		Employees employee = new Employees();
		employee.setFirstName("Steve");
		employee.setLastName("Jobs");
		employee.setEmployeeNumber(1234);
		employee.setGender("M");

		SimpleDateFormat hiredSdf = new SimpleDateFormat("yyyy-mm-dd");
		String dateInString = "1975-05-26";
		Date hiredDate = (Date) hiredSdf.parse(dateInString);

		employee.setHiredDate(hiredDate);

		SimpleDateFormat dobSdf = new SimpleDateFormat("yyyy-mm-dd");
		String dobDateInString = "1965-02-21";
		Date dobDate = (Date) dobSdf.parse(dobDateInString);

		employee.setDob(dobDate);
		// The commented line creates a new user in database
		// employeeService.save(employee);

		List<Employees> employeesList = employeeService.employeesList();

		for (Employees e : employeesList)
		{
			System.out.println(e.getEmployeeNumber() + " \t" + e.getFirstName() + " "
					+ e.getLastName());
		}

	}
}
