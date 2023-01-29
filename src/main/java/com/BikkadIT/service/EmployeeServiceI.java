package com.BikkadIT.service;
import java.util.List;
public class EmployeeServiceI {






	public int  saveEmployeeService(Employee employee);
	
	public List<Employee>  getAllEmployeesService();
	
	public  Employee loginCheck(Employee employee);
	
	 public Employee  editEmployee(int uid);
	
	 public Employee update(Employee Employee);
	
	public boolean delete(int uid);
	
}