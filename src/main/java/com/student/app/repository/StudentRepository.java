package com.student.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.app.model.Info;

@Repository
public interface StudentRepository extends JpaRepository<Info, Long> {

	List<Info> findByCourseId(int courseId);

	Info findById(int id);

	

}
