package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Student;
import com.example.demo.repository.Studentrepo;


@RestController
public class StudentRestController {
	@Autowired
	Studentrepo repo;

	@GetMapping("/student/view")
	public List<Student> view() {

		return repo.findAll();
	}

	@PostMapping("/student/insert")
	public Student insert(@RequestBody Student student) {

		return repo.save(student);
	}
	
	@PostMapping("/student/update")
	public Student update(@RequestBody Student student) {

		return repo.save(student);
	}
	
	@DeleteMapping("/student/delete/{id}")
	public List<Student> delete(@PathVariable Integer id) {

		repo.deleteById(id);
		return repo.findAll();
	}
	

}
