package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.beans.Student;
import com.example.demo.repository.Studentrepo;



@Controller
public class StudentController {
	@Autowired
	private Studentrepo repo;
	@GetMapping("/student")
public String index() {
		System.out.println("/index mapped");
	return "index";
}
	@PostMapping("/insert")
		public String insert(Student student) {
		repo.save(student);
		System.out.println("/insert mapped");
			return "insert";
	}
	@GetMapping("/all")
	public String getStudent(Model model) {
		ArrayList<Student>list =new ArrayList<Student>();
		list=(ArrayList<Student>) repo.findAll();
		 model.addAttribute("list",list);  
	        return "view";    
	}
	/* @RequestMapping(value="/editstudent/{id}")    
	    public String edit(@PathVariable int id, Model m){    
	     Student student=repo.getStudentById(id);   
			m.addAttribute("command",student);  
	        return "insert";    
	    }    
	 @RequestMapping(value="/editsave",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute("student") Student student){    
	        repo.update(student);    
	        return "redirect:/all";    
	    } */  
	@RequestMapping(value="/deletelist/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        repo.deleteById(id);    
        return "redirect:/all";    
    }     
}
