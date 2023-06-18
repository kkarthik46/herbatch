package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
@Autowired
StudentRepo repo;


@RequestMapping("/")
public ModelAndView basepage(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	mv.setViewName("index.jsp");
	return mv;
}


@RequestMapping("/insert")
	public ModelAndView insert(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Student s=new Student();
		s.setName(request.getParameter("name"));
		s.setEmail(request.getParameter("email"));
		Student student=repo.save(s);
		if(student!=null) {
			mv.setViewName("display.jsp");
		}
		return mv;
	}


@RequestMapping("/view")
public ModelAndView view(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	List<Student> list=repo.findAll();
	mv.setViewName("displayall.jsp");
	mv.addObject("list", list);
	return mv;
}
}