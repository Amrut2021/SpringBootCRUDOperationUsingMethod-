package com.Tka.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Tka.Entity.Product;
import com.Tka.Service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class ProductController {
	@Autowired
	ProductService service;
	
	
	@PostMapping("/ProductSaveData")
	public String insertData(@RequestBody  Product p) {
		String msg=service.insertdata(p);
		return msg;
	}
	
	@DeleteMapping("/ProductDeleteData/{id}")
	public String deleteData(@PathVariable int id) {
		String msg=service.deleteData(id);
		return msg;
	}
	
	@GetMapping("/ProductGetSingleData/{id}")
	public Product getSingleData(@PathVariable int id) {
		Product msg=service.getSingleData(id);
		return msg;
	}
	
	@PutMapping("/ProductUpdateData/{id}")
	 public String updateData(@RequestBody  Product p,@PathVariable int id) {
		 String msg=service.updateData(p, id);
			return msg;
	 }
	
	@GetMapping("/ProductGetAll")
	public List<Product> getAll(){
		List<Product> list=service.getAll();
		return list;
		
	}
	
	
	
	

}
