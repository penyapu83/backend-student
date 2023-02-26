package com.student.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.exception.RecordNotFoundException;
import com.student.app.exception.ServerException;
import com.student.app.model.Course;
import com.student.app.model.Info;
import com.student.app.service.StudentService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {
	
	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService studentService;	
	
	
	@GetMapping("/hello-world")
	public String HelloWorld(){
	return "Hello World";
	}

	
	@GetMapping("/student/findAllStudent")
	public ResponseEntity<List<Info>> getAll() {
		return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
	}
	  
	@GetMapping("/student/findStudentByCourseId/{courseId}") 
	public ResponseEntity<List<Info>>findByCourseId(@PathVariable int courseId) { 
		return new	ResponseEntity<>(studentService.findByCourseId(courseId), HttpStatus.OK); 
	}
	
	@GetMapping("/student/findStudentById/{id}") 
	public ResponseEntity<?>findStudentById(@PathVariable int id) { 
		return new	ResponseEntity<>(studentService.findStudentById(id), HttpStatus.OK); 
	}
	 
	
	@PostMapping("/student/create")
	public ResponseEntity<?> createResult(@Valid @RequestBody Info result) {

		return new ResponseEntity<>(studentService.createResult(result), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/student/update/{id}")
	public ResponseEntity<Info> update(@RequestBody final Info updatedResult, @PathVariable int id) {
		updatedResult.setId(id);
		Info cal = studentService.save(updatedResult);
		if (cal == null) {
			throw new ServerException();
		} else {
			return new ResponseEntity<>(cal, HttpStatus.OK);
		}
	}
	  
	@DeleteMapping("/student/delete/{id}")
	public HttpStatus delete(@PathVariable final long id) {

		
		try {
			Optional<Info> info =studentService.findById(id);
			
			System.out.println("id to delete :" + info.get().getId());
			
			if(info.isPresent()) {
				studentService.delete(id);
			
				return HttpStatus.OK;
			}
		} catch (Exception e) {
			throw new RecordNotFoundException();
		}
		return HttpStatus.NOT_FOUND;
	}
	
	
	
}
