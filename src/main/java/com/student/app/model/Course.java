package com.student.app.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name ="course")
public class Course implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private int id;
    
    @Column(nullable=false, length=100)
    private String name;
    
    

    /** Default constructor. */
    public Course() {
        super();
    }
    
    

	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		
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

	

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
   
    
    
}
