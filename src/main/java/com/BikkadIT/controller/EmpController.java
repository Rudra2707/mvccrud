
package com.BikkadIT.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BikkadIT.model.Employee;
import com.BikkadIT.service.EmployeeServiceI;

@Controller
public class EmpController {

	
	@Autowired
	private EmployeeServiceI EmployeeServiceI;
	
	
	@GetMapping("/registration")
	public String preregister() {
		
		return "registration";
		
	}
	
	@GetMapping("/Login")
	public String preLogin() {
	
		return "Login";
		
	}
	
	@PostMapping("/reg")
	public String saveEmpController(Employee Employee,Model model) {
		System.out.println("Controller layer");
		System.out.println(Employee);
		int id = EmployeeServiceI.saveEmployeeService(Employee);
		model.addAttribute("id", id);
		System.out.println(id);
		return "reg";
		
	}
	
	@GetMapping("/getAllData")
	public String getAllEmpController(Model model){
	
		List<Employee> list = EmployeeServiceI.getAllEmployeesService();
		System.out.println(list);
		model.addAttribute("list", list);
		
		return "getAllData" ;
		
	}
	
	
	@PostMapping("/log")
	public String loginCheck(Employee Employee,Model model) {
		System.out.println(Employee);
		Employee Employee1 = EmployeeServiceI.loginCheck(Employee);
		
		if(Employee1==null) {
			return "loginFail";
		}
		
		return "LoginSuccess";
		
	}
	
	@GetMapping("/edit/{uid}")
	public String editEmployee(@PathVariable int uid,Model model) {
		
	Employee Employee = EmployeeServiceI.editEmployee(uid);
	model.addAttribute("Employee", Employee);
	
	return "edit";
		
		
	} 
	
	@GetMapping("/up")
	public String preUpdate() {
		return "up";
		
	}
	
	@PostMapping("/update")
	public String updateEmployee(Employee Employee,Model model) {
		
		Employee Employee2 = EmployeeServiceI.update(Employee);
		
		model.addAttribute("Employee2", Employee2);
		return "update";
		
	}
	
	@GetMapping("/delete/{uid}")
	public String deleteEmployee(@PathVariable int uid) {
	
		 boolean delete = EmployeeServiceI.delete(uid);
		 
		 if(delete) {
		   return "delete";
		 }
		 return "notdelete";
		
	}
	
	
	
	
	
}
