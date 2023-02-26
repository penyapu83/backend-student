package com.student.app.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.app.model.Course;
import com.student.app.model.Info;
import com.student.app.repository.StudentRepository;



@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	
	
	public List<Info> getAll() { 
		return	studentRepository.findAll(); 
	}
	 
	  
	public List<Info> findByCourseId(int id) { 
		return studentRepository.findByCourseId(id); 
	}
	 

	public Info createResult(Info result) {
		
	try {
		Info newInfo = new Info();
		newInfo.setName(result.getName());
		newInfo.setMatricNo(result.getMatricNo());
		newInfo.setAge(result.getAge());
		newInfo.setCourseId(result.getCourseId());
				
		return studentRepository.save(newInfo);
    } catch (Exception e) {
    	//LOG.error(e.getMessage());
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String stackTrace = sw.toString();
		//LOG.error("Exception - " + stackTrace);
		throw e;
    }
		
	}

	public Info save(Info updatedResult) {
		return studentRepository.save(updatedResult);
	}

	public void delete(long id) { 
		studentRepository.deleteById(id); 
	}


	public Optional<Info> findById(long id) {
		return studentRepository.findById(id); 
	}


	public Info findStudentById(int id) {
		return studentRepository.findById(id); 
	}
	
	
}
