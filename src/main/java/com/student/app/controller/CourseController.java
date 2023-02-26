package com.student.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.model.Course;
import com.student.app.service.CourseService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	CourseService courseService;	
	
	@GetMapping("/student/findAllCourse")
	public ResponseEntity<List<Course>> getAllCourse() {
		return new ResponseEntity<>(courseService.getAllCourse(), HttpStatus.OK);
	}
	 
	
	
	
	
	
}
