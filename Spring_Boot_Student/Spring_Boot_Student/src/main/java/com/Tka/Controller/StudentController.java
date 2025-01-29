package com.Tka.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Tka.Entity.Student;
import com.Tka.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService Service;
	
	@PostMapping("/StudentSaveData")
	public String insertData(@RequestBody Student s) {
		String msg=Service.insertData(s);
		return msg;
	}
	
	@DeleteMapping("/StudentDeleteData/{id}")
	public String deleteData(@PathVariable int id) {
		String msg=Service.deleteData(id);
		return msg;
	}
	
	@GetMapping("/StudentGetSingle")
	public Student getSingleData(@RequestParam  int id) {
		Student msg=Service.getSingleData(id);
		return msg;
	}
	
	@PutMapping("/StudentUpdateData/{id}")
	public String updateData(@PathVariable int id,@RequestBody Student us) {
		String msg=Service.updateData(id,us);
		return msg;
	}
	
	@GetMapping("/StudentGetAll")
	public List<Student>getAllRec(){
		List<Student>list=Service.getAllRec();
		return list;
	}
	
	
	

}
