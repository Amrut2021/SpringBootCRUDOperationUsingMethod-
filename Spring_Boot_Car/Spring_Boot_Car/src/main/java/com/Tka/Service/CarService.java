package com.Tka.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tka.Dao.CarDao;
import com.Tka.Entity.Car;

@Service
public class CarService {
	
	@Autowired
	CarDao Dao;
	
	public String insertData(Car c) {
		String msg=Dao.insertData(c);
		return msg;
	}

	public String deleteData(int id) {
		String msg=Dao.deleteData(id);
		return msg;
	}
	
	public Car getSingleData(int id) {
		Car msg=Dao.getSingleData(id);
		return msg;
	}
	
	public String updateData(Car c,int id) {
		String msg=Dao.updateData(c, id);
		return msg;
	}
	public List<Car> getAll(){
		List<Car>list=Dao.getAll();
		return list;
	}
}
