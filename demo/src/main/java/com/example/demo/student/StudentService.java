package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service // Tells this class is meant to be a service and 
		 // it must be instantiated(spring bean)
public class StudentService {
	
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
