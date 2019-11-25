package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.beans.Student;
import com.example.demo.repository.Studentrepo;



@Controller
public class StudentController {
	@Autowired
	private Studentrepo repo;
@GetMapping("/index")
public String index() {
		
	return "index";
}
	@PostMapping("/logAction")
		public String insert(Student student,Model model) {
		repo.save(student);
		List<Student>list =new ArrayList<Student>();
		list=repo.findAll();
		 model.addAttribute("list",list);  
		System.out.println("/insert mapped");
		return "view";
	}
	@GetMapping("/view")
	public String getStudent(Model model) {
		ArrayList<Student>list =new ArrayList<Student>();
		list=(ArrayList<Student>) repo.findAll();
		 model.addAttribute("list",list);  
	        return "view";    
	}
	@GetMapping("/edit")
public String editStudent(String r,String name,int id,String pass,Model model) {
		
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		model.addAttribute("pass", pass);
		

		model.addAttribute("val", r);
		
		List<Student> lists=new ArrayList<Student>();
		lists=repo.findAll();
		model.addAttribute("list", lists);
		return "index";
	
	}
	@RequestMapping(value="/deletelist/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        repo.deleteById(id);    
        return "redirect:/view";    
    }     
}
