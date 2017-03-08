package com.infotech.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infotech.model.Employee;
import com.infotech.service.EmployeeService;
import com.infotech.service.impl.EmployeeServiceImpl;

public class Test {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		EmployeeService employeeService = ctx.getBean("employeeService", EmployeeServiceImpl.class);
		//createEmployee(employeeService);
		//getEmployeeById(employeeService);
		
		fetchAllEmployeesInfo(employeeService);
		
		//employeeService.updateEmployeeEmailById("Jimmy.s100@yahoo.com", 2);
		//employeeService.deleteEmployeeById(13);
		ctx.close();
	}

	private static void fetchAllEmployeesInfo(EmployeeService employeeService) {
		List<Employee> empList = employeeService.getAllEmployeesInfo();
		for (Employee employee : empList) {
			System.out.println(employee.getEmployeeId()+"\t"+employee.getEmployeeName()+"\t"+employee.getEmail()+"\t"+employee.getGender()+"\t"+employee.getSalary());
		}
	}

	private static void getEmployeeById(EmployeeService employeeService) {
		Employee employee = employeeService.fetchEmployeeById(2);
		System.out.println(employee.getEmployeeId()+"\t"+employee.getEmployeeName()+"\t"+employee.getEmail()+"\t"+employee.getGender()+"\t"+employee.getSalary());
	}

	private static void createEmployee(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setEmail("Tommy.s@yahoo.com");
		employee.setEmployeeName("Tommy");
		employee.setGender("Male");
		employee.setSalary(40000.00);
		
		employeeService.addEmployee(employee);
	}

}
