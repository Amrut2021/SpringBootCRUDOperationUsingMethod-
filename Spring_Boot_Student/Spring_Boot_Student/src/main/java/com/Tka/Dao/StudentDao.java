package com.Tka.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Tka.Entity.Student;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory Factory;

	public String insertData(Student s) {
		Session session=null;
		Transaction tr=null;
		String msg=null;
		try {
		session= Factory.openSession();
		tr = session.beginTransaction();
		session.persist(s);
		tr.commit();
		msg="Data is inserted";
		}
		catch (Exception e) {
			if(tr!=null) {
				tr.rollback();
			}
			e.printStackTrace();			
		}
		finally {
			if (session!=null) {
				session.close();				
			}			
		}		
		return msg;
	}

	public String deleteData(int id) {
		Session ss = Factory.openSession();
		Transaction tr = ss.beginTransaction();
		Student s = ss.get(Student.class, id);
		ss.remove(s);
		tr.commit();
		ss.close();
		return "Data Deleted";
	}

	public Student getSingleData(int id) {
		Session ss = Factory.openSession();
		Transaction tr = ss.beginTransaction();
		Student s = ss.get(Student.class, id);
		tr.commit();
		ss.close();
		return s;
	}

	public String updateData(int id, Student us) {
		Session ss = Factory.openSession();
		Transaction tr = ss.beginTransaction();
		Student s = ss.get(Student.class, id);
		s.setName(us.getName());
		s.setAge(us.getAge());
		s.setCourse(us.getCourse());
		s.setEmail(us.getEmail());
		s.setMoblieNo(us.getMoblieNo());
		ss.merge(s);
		tr.commit();
		ss.close();
		return "Data updated";
	}
	public List<Student> getAllRec() {
		Session ss=Factory.openSession();
		Transaction tr=ss.beginTransaction();
		
		CriteriaBuilder cb=ss.getCriteriaBuilder();
		CriteriaQuery<Student>cq=cb.createQuery(Student.class);
		Root<Student>root=cq.from(Student.class);
		cq.select(root);
		Query<Student> query=ss.createQuery(cq);
		
		List<Student>list=query.getResultList();
		tr.commit();
		ss.close();
		return list;
		
		
		
	}
}
