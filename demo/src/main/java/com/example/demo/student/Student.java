package com.example.demo.student;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity // Annotation for Hibernate - ORM used to save Java objects in the db
@Table // Maps the table to the db, specify details of the table to persist in the db 
public class Student {
	@Id // Defines the primary key for the table
	// Sequence generator used to add a sequence generator strategy for the table
	@SequenceGenerator(
			name = "student_sequence", // Generator name - referenced by classes to be the generator for PK values
			sequenceName = "student_sequence", // the name for the db sequence object to obtain PK values
			allocationSize = 1 // Amount to increment sequence numbers by
			) 
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, // Tells persistence provider to assign PK value using db sequence
			generator = "student_sequence") // Specify which sequence to use for the generator (one we created above)
	
	// Student class attributes
	private Long id;
	private String name;
	private String email;
	private LocalDate dob;
	private Integer age;
	
	// Default constructor with no arguments
	public Student() {

	}
	// Constructor without id argument for creating a new user - db will provide id
	public Student(
			String name, 
			String email, 
			LocalDate dob, 
			Integer age) {
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}
	// Constructor with all attributes
	public Student(
			Long id, 
			String name, 
			String email, 
			LocalDate dob, 
			Integer age) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}
	// Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
	
	
}
