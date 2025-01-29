package com.Tka.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Tka.Entity.Employee;
import com.Tka.Service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService Service;
	
	@PostMapping("/EmpSaveData")
	public String EmployeeService(@RequestBody Employee e) {	
		String msg=Service.insertData(e);
		return msg;
	}
	@DeleteMapping("/EmpDeleteData/{id}")
	public String deleteData(@PathVariable int id)
	{
		String msg=Service.deleteData(id);
		return msg;
	}
	
	@GetMapping("/EmpGetSingleData/{id}")
	public Employee getSingleData(@PathVariable int id) {
		Employee msg=Service.getSingleData(id);
		return msg;
	}
	
	@PutMapping("/EmpUpdate/{id}")
	public String updateData(@PathVariable int id,@RequestBody Employee e) {
		String msg=Service.updateData(id, e);
		return msg;
	}
	
	@GetMapping("/EmpGetAll")
	public List<Employee> getAllrec(){
		List<Employee>list=Service.getAllRec();
		return list;
	}
	

}
