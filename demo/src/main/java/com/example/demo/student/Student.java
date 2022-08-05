package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity // Annotation for Hibernate - ORM used to save Java objects in the db
@Table // Maps the table to the db, specify details of the table to persist in the db 
public class Student {
	/*
	 * @Id Defines the primary key for the table
	 * 
	 * @SequenceGenerator used to add a sequence generator strategy for the table
	 *
	 * name - generator name, referenced by classes to be the generator for PK
	 * values sequenceName - the name for the db sequence object to obtain PK values
	 * allocationSize - amount to increment sequence numbers by
	 */	
	@Id 
	@SequenceGenerator(
			name = "student_sequence", 
			sequenceName = "student_sequence", 
			allocationSize = 1
			)
	/*
	 * @GeneratedValue - provides for the specification of generation strategies for the values of primary keys
	 * strategy - tells persistence provider to assign PK value using db sequence
	 * generator - Specify which sequence to use for the generator
	 */
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, 
			generator = "student_sequence"
			) 
	
	// Student class attributes
	private Long id;
	private String name;
	private String email;
	private LocalDate dob;
	/*
	 * @Transient tells app this attribute doesn't need to be a column in the db. The
	 * The age will be auto calculated for us.
	 */
	@Transient 
	private Integer age;
	
	// Default constructor with no arguments
	public Student() {
	}
	// Constructor without id argument for creating a new user - db will provide id
	public Student(
			String name, 
			String email, 
			LocalDate dob) {
		this.name = name;
		this.email = email;
		this.dob = dob;
	}
	// Constructor with all attributes
	public Student(
			Long id, 
			String name, 
			String email, 
			LocalDate dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
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
		// Calculate the students age
		return Period.between(this.dob, LocalDate.now()).getYears();
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student{" +
				"id=" + id + " " +
				"name=" + name + " " +
				"email=" + email + " " +
				"dob=" + dob + " " +
				"age=" + age +
				"}";
	}
	
	
	
}
