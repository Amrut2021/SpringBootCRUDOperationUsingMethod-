package com.Tka.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tka.Dao.ProductDao;
import com.Tka.Entity.Product;

@Service

public class ProductService {
	
	@Autowired
	ProductDao Dao;
	
	public String insertdata(Product p) {
		String msg=Dao.insertData(p);
		return msg;
	}
	public String deleteData(int id) {
		String msg=Dao.deleteData(id);
		return msg;
	}
	
	public Product getSingleData(int id) {
		Product msg=Dao.getSingleData(id);
		return msg;
		
	}
	
	 public String updateData(Product p,int id) {
		 String msg=Dao.updateData(p, id);
			return msg;
	 }
	 
	 public List<Product> getAll( ){
		List<Product>list = Dao.getAll();
		return list;
	 }
	
	

}
