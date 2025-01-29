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

import com.Tka.Entity.Bird;
import com.Tka.Service.BirdService;

@RestController
public class BirdController {
	
	@Autowired
	BirdService Service;
	
	@PostMapping("/BirdSave")
	public String insertData(@RequestBody Bird b)
	{
		String msg=Service.insertData(b);
		return msg;
	}
	
	
	@DeleteMapping("/BirdDeleteData/{id}")
	public String deleteData(@PathVariable  int id)
	{
		String msg=Service.deleteData(id);
		return msg;
	}

	@GetMapping("/BirdGetSingleData/{id}")
	public Bird getSingleData(@PathVariable  int id)
	{
		Bird msg=Service.getSingleData(id);
		return msg;
	}
	@PutMapping("/BirdUpdate/{id}")
	public String updateData(@RequestBody Bird b,@PathVariable int id) {
		String msg=Service.updateData(b, id);
		return msg;
	}
	
	@GetMapping("/BirdGetAll")
	public List<Bird>getAll(){
		List<Bird>list=Service.getAll();
		return list;
	}
}
