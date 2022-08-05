package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // gives this class RESTful functionality
@RequestMapping(path = "api/v1/student")// Routes HTTP requests
public class StudentController {
	
	// Access methods inside StudentService with instance variable
	private final StudentService studentService;
	
	/*
	 * Constructor for StudentController with StudentService parameter Uses
	 * dependency injection to give this class its instance variables
	 */
	
	@Autowired // Autowires(instantiates) and injects StudentService into the constructor
	 public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping // Annotation allows server to serve/respond to GET requests
	public List<Student> getStudents() { return studentService.getStudents(); }
	
	/*
	 * @RequestBody will map the request body into the Student object
	 * @PostMapping allows server to accept/process POST requests
	 */
	@PostMapping 
	public void registerNewStudent(@RequestBody Student student) {
		studentService.addNewStudent(student);
	}
	
	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		studentService.deleteStudent(studentId);
	}
	
	@PutMapping(path = "{studentId}")
	public void updateStudent(
			@PathVariable("studentId") Long studentId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {
		studentService.updateStudent(studentId, name, email);
	}

}
