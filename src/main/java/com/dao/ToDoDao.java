package com.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.entity.ToDo;
@Component
public class ToDoDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate; 

	@Transactional
	public int save(ToDo t) {
		
		 Integer i=(Integer) this.hibernateTemplate.save(t);
		 return i;
		
	}
	
	public List<ToDo> getAll(){

		List<ToDo> list = this.hibernateTemplate.loadAll(ToDo.class);
		return list;
		
		
		
	}
	
	@Transactional
	public void deleteToDo(int id) {
		
		ToDo todo=this.hibernateTemplate.load(ToDo.class, id);
		this.hibernateTemplate.delete(todo);
		 
		
	}
	
	
}
