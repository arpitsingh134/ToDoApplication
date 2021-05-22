package com.controller;

import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.ToDoDao;
import com.entity.ToDo;

@Controller
public class HomeController {

	@Autowired
	ServletContext context;
	@Autowired
	ToDoDao todoDao;

	@RequestMapping("/home")
	public String Home(Model m) {

		List<ToDo> list = this.todoDao.getAll();

		String str = "home";
		m.addAttribute("page", str);
		m.addAttribute("todos", list);
		return "home";
	}

	@RequestMapping("/add")
	public String addToDo(Model m) {
		ToDo t = new ToDo();

		String str = "add";
		m.addAttribute("page", str);
		m.addAttribute("todo", t);
		return "home";
	}

	@RequestMapping(value = "/saveToDo", method = RequestMethod.POST)
	public String saveToDo(@ModelAttribute("todo") ToDo t, Model m) {

		t.setAddedDate(new Date());
		this.todoDao.save(t);
		m.addAttribute("msg", "successfull");
		m.addAttribute("page", "home");
		return "forward:" + "/home";
	}

	@RequestMapping(value = "/deleteToDo/{id}", method = RequestMethod.GET)
	public String deleteToDo(@PathVariable("id") int id, Model m) {
		System.out.println(id);

		System.out.println("deleted id =" + id);
		this.todoDao.deleteToDo(id);
		m.addAttribute("msg", "Deletion is Success");
		m.addAttribute("page", "home");
		return "forward:" + "/home";
	}

}
