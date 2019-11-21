package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.Student;
@Repository
public interface Studentrepo extends JpaRepository<Student,Integer> {
List<Student>findByName(String name);
List<Student>findByIdBetween(Integer start,Integer stop);

}
