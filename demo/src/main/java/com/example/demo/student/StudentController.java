package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // gives this class RESTful functionality
@RequestMapping(path = "api/v1/student")// Routes HTTP requests
public class StudentController {
	
	// Access methods inside StudentService with instance variable
	private final StudentService studentService;
	
	// Constructor for StudentController with StudentService parameter
	// Uses dependency injection to give this class its instance variables
	@Autowired // Autowires(instantiates) and injects StudentService into the constructor
	 public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping // Annotation allows server to serve/respond to GET requests
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

}
