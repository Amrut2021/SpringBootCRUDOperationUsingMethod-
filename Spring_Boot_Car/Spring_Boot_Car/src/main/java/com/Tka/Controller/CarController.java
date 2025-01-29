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

import com.Tka.Entity.Car;
import com.Tka.Service.CarService;

@RestController
public class CarController {

	@Autowired
	CarService Service;

	@PostMapping("/CarSaveData")
	public String insertData(@RequestBody Car c) {
		String msg = Service.insertData(c);
		return msg;
	}

	@DeleteMapping("/CarDeleteData/{id}")
	public String deleteData(@PathVariable int id) {
		String msg = Service.deleteData(id);
		return msg;

	}

	@GetMapping("/CarGetSingleData/{id}")
	public Car getSingleData(@PathVariable int id) {
		Car msg=Service.getSingleData(id);
		return msg;
		
	}
	
	@PutMapping("/CarUpdateData/{id}")
	public String updateData(@RequestBody Car c,@PathVariable int id) {
		String msg=Service.updateData(c, id);
		return msg;
	}
	
	@GetMapping("/CarGetAll")
	public List<Car> getAll() {
		List<Car>list=Service.getAll();
		return list;
	}
	

}
