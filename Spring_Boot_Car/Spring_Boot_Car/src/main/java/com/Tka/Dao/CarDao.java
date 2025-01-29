package com.Tka.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Tka.Entity.Car;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class CarDao {
	@Autowired
	SessionFactory factory;

	public String insertData(Car c) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		ss.persist(c);
		ss.close();
		tr.commit();
		return "Data inserted...";

	}
	
	public String deleteData(int id) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		Car c1=ss.get(Car.class, id);
		ss.remove(c1);
		tr.commit();
		ss.close();
		return "Data deleted";
	}
	
	public Car getSingleData(int id) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		Car c=ss.get(Car.class, id);
		tr.commit();
		ss.close();
		return c;
	}
	
	public String updateData(Car c,int id) {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		
		Car c1=ss.get(Car.class,id);
		c1.setName(c.getName());
		c1.setModel(c.getModel());
		c1.setColor(c.getColor());
		c1.setPrice(c.getPrice());
		ss.merge(c1);	
		tr.commit();
		ss.close();
		return "Data Updated";		
	}
	
	public List<Car> getAll(){
		
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		
		CriteriaBuilder cb=ss.getCriteriaBuilder();
		CriteriaQuery<Car> cq=cb.createQuery(Car.class);
		Root<Car>root=cq.from(Car.class);
		cq.select(root);
		
		Query<Car>query=ss.createQuery(cq);
		List<Car>list=query.getResultList();
		tr.commit();
		ss.close();
		return list;
		
	}
	

}
