package com.student.app.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.app.model.Course;
import com.student.app.model.Info;
import com.student.app.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;

	
	public List<Course> getAllCourse() { 
		return	courseRepository.findAll(); 
	}
	 

	

	
	
	
	
}
