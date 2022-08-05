package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*@Service annotation indicates this class is meant to be a service and 
it must be instantiated(spring bean)*/

@Service 
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired // Maps and injects StudentRepository bean into StudentService
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() { return studentRepository.findAll(); }
	
	public void addNewStudent(Student student) {
		Optional<Student> studentByEmail =
				studentRepository.findStudentByEmail(student.getEmail());
		if(studentByEmail.isPresent()) {
			throw new IllegalStateException("Email taken");
		}
		studentRepository.save(student);
		System.out.println(student);
	}

}
