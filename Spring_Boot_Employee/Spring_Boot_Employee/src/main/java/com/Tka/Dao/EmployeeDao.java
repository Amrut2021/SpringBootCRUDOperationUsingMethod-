package com.Tka.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Tka.Entity.Employee;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory factory;

	public String insertData(Employee e) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		ss.persist(e);
		tr.commit();
		ss.close();
		return "Data inserted...";

	}

	public String deleteData(int id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Employee e1 = ss.get(Employee.class, id);
		ss.remove(e1);
		tr.commit();
		ss.close();
		return "Data Deleted";

	}

	public Employee getSingleData(int id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Employee e = ss.get(Employee.class, id);
		tr.commit();
		ss.close();
		return e;
	}
	
	public String updateData(int id,Employee e) {
		Session ss= factory.openSession();
		Transaction tr=ss.beginTransaction();	
		Employee e1=ss.get(Employee.class,id);
		e1.setId(e.getId());
		e1.setName(e.getName());
		e1.setDepartment(e.getDepartment());
		e1.setCity(e.getCity());
		e1.setSalary(e.getSalary());
		ss.merge(e1);
		tr.commit();
		ss.close();
		return"Data updated";		
	}
	
	public List<Employee> getAllRec() {
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		
		CriteriaBuilder cb=ss.getCriteriaBuilder();
		CriteriaQuery<Employee>cq=cb.createQuery(Employee.class);
		Root<Employee>root=cq.from(Employee.class);
		cq.select(root);
		Query<Employee>query=ss.createQuery(cq);
		List<Employee>list=query.list();
		tr.commit();
		return list;
	}

}
