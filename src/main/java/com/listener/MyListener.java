package com.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.entity.ToDo;

public class MyListener  implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//ServletContextListener.super.contextDestroyed(sce);
	}

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//ServletContextListener.super.contextInitialized(sce);
		
		
		System.out.println("context created ");
		
		List<ToDo> list=new ArrayList<ToDo>();
		ServletContext context=sce.getServletContext();
		context.setAttribute("list", list);
	}
	
	
	
	

}
