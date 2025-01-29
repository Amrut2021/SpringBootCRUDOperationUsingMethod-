package com.Tka.Service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tka.Dao.StudentDao;
import com.Tka.Entity.Student;

@Service
public class StudentService {

	@Autowired
	StudentDao Dao;

	public String insertData(Student s) {
		String msg = Dao.insertData(s);
		if(Objects.isNull(msg)) {
			msg="insert All fileds properly";
		}
		return msg;
	}
	public String deleteData(int id) {
		String msg=Dao.deleteData(id);
		return msg;
	}
	
	public Student getSingleData(int id) {
		Student msg=Dao.getSingleData(id);
		return msg;
	}
	
	public String updateData(int id,Student us) {
		String msg=Dao.updateData(id,us);
		return msg;
	}
	
	public List<Student> getAllRec() {
		List<Student>list=Dao.getAllRec();
		return list;
		
	}

}
