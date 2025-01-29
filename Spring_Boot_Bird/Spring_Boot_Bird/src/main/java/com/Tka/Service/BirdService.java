package com.Tka.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tka.Dao.BirdDao;
import com.Tka.Entity.Bird;

@Service
public class BirdService {
	@Autowired
	BirdDao dao;
	
	public String insertData(Bird b)
	{
		String msg=dao.insertData(b);
		return msg;
	}
	
	public String deleteData(int id)
	{
		String msg=dao.deleteData(id);
		return msg;
	}
	
	public Bird getSingleData(int id) {
		Bird msg=dao.getSingleData(id);
		return msg;
	}
	
	public String updateData(Bird b,int id) {
		String msg=dao.updateData(b, id);
		return msg;
	}
	
	public List<Bird>getAll(){
		List<Bird>list=dao.getAll();
		return list;
	}


}
