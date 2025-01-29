package com.Tka.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tka.Dao.EmployeeDao;
import com.Tka.Entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao Dao;
	
	public String insertData(Employee e) {
		String msg=Dao.insertData(e);
		return msg;
		
	}
	
	public String deleteData(int id) {
		String msg=Dao.deleteData(id);
		return msg;
	}
	
	public Employee getSingleData(int id) {
		Employee msg=Dao.getSingleData(id);
		return msg;
	}
	public String updateData(int id,Employee e) {
		String msg=Dao.updateData(id, e);
		return msg;
	}
	
	public List<Employee> getAllRec(){
		List<Employee>list=Dao.getAllRec();
		return list;
	}
	

}
