package com.Tka.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Tka.Entity.Bird;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class BirdDao {

	@Autowired
	SessionFactory factory;

	public String insertData(Bird b) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		ss.persist(b);
		ss.close();
		tr.commit();
		return "Data inserted..";
	}

	public String deleteData(int id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Bird b1 = ss.get(Bird.class, id);
		ss.remove(b1);
		tr.commit();
		ss.close();
		return "Data Deleted...";

	}

	public Bird getSingleData(int id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Bird b = ss.get(Bird.class, id);
		tr.commit();
		ss.close();
		return b;
	}

	public String updateData(Bird b, int id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		Bird b1 = ss.get(Bird.class, id);
		b1.setName(b.getName());
		b1.setColor(b.getColor());
		b1.setWeight(b.getWeight());
		ss.merge(b1);
		tr.commit();
		ss.close();
		return "Data Updated...";
	}
	
	public List<Bird> getAll(){
		Session ss=factory.openSession();
		Transaction tr=ss.beginTransaction();
		
		CriteriaBuilder cb=ss.getCriteriaBuilder();
		CriteriaQuery<Bird>cq=cb.createQuery(Bird.class);
		Root<Bird>root=cq.from(Bird.class);
		cq.select(root);
		Query<Bird>query=ss.createQuery(cq);
		
		List<Bird>list=query.getResultList();
		tr.commit();
		ss.close();
		return list;
		
	}

}
