package com.Tka.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Tka.Entity.Product;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository

public class ProductDao {
	
	@Autowired
	SessionFactory factory;
	
	public String insertData(Product p) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		ss.persist(p);
		tr.commit();
		ss.close();
		return "Data inserted...";
	}
	  public String deleteData(int id) {
		  Session ss=factory.openSession();
		  Transaction tr=ss.beginTransaction();
		 Product p= ss.get(Product.class, id);
		 ss.remove(p);
		 tr.commit();
		 ss.close();
		  return"Data deleted";
	  }
	  
	  public Product getSingleData(int id) {
		  Session ss=factory.openSession();
		  Transaction tr=ss.beginTransaction();
		  Product p=ss.get(Product.class, id);
		  tr.commit();
		  ss.close();
		  return p;
	  }
	  
	  public String updateData(Product p,int id) {
		  Session ss=factory.openSession();
		  Transaction tr=ss.beginTransaction();
		  Product p1=ss.get(Product.class, id);
		  p1.setName(p.getName());
		  p1.setCategory(p.getCategory());
		  p1.setPrice(p.getPrice());
		  p1.setQuantity(p.getQuantity());
		  ss.merge(p1);
		  tr.commit();
		  ss.close();
		  return "Data updated...";		  
	  }
	  public List<Product> getAll(){
		  Session ss=factory.openSession();
		  Transaction tr=ss.beginTransaction();
		  
		  CriteriaBuilder cb=ss.getCriteriaBuilder();
		  CriteriaQuery<Product>cq=cb.createQuery(Product.class);
		  Root<Product>root=cq.from(Product.class);
		  cq.select(root);
		  Query<Product>query=ss.createQuery(cq);
		  List<Product>list=query.list();
		  tr.commit();
		  ss.close();
		  return list;
		  
	  }

}
