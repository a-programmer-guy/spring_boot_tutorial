package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // gives this class RESTful functionality
@RequestMapping(path = "api/v1/student")// Routes HTTP reqs to handler methods/controllers 
public class StudentController {
	@GetMapping // Annotation allows server to serve/respond to GET requests
	public List<Student> getStudents() {
		return List.of(
				new Student(
						1L,
						"Tony",
						"Soprano@gmail.com",
						LocalDate.of(2000,Month.APRIL,20),
						20
						));
	}
}
