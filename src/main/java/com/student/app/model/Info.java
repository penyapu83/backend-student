package com.student.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name ="info")
public class Info implements Serializable {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique=true, nullable = false)
    private int id;

    @Column(nullable=false, length=100)
    private String name;
    
    @Column(nullable=false)
    private int age;
    
    @Column(nullable=false, length=100)
    private String matricNo;
    
    @Column(name="course_id", nullable=false) 
    private int courseId;   
    
    
    @ManyToOne(optional=false)
    @JoinColumn(name="course_id", insertable=false, updatable=false)    
    private Course course;

    /** Default constructor. */
    public Info() {
        super();
    }

	public Info(int id, String name, int age, String matricNo, int courseId, Course course) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.matricNo = matricNo;
		this.courseId = courseId;
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMatricNo() {
		return matricNo;
	}

	public void setMatricNo(String matricNo) {
		this.matricNo = matricNo;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Info [id=" + id + ", name=" + name + ", age=" + age + ", matricNo=" + matricNo + ", courseId="
				+ courseId + ", course=" + course + "]";
	}
}
