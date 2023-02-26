package com.student.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.app.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


}
