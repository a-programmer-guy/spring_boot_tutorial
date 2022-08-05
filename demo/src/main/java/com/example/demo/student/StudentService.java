package com.example.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*@Service annotation indicates this class is meant to be a service and 
it must be instantiated(spring bean)*/

/**
 * @author kay
 *
 */
@Service 
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired // Maps and injects StudentRepository bean into StudentService
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	/**
	 * getStudents returns a list of students
	 * @return the list of students from the db
	 */
	public List<Student> getStudents() { return studentRepository.findAll(); }
	
	
	/** 
	 * @param student is the Student entity to be added to the db
	 */
	public void addNewStudent(Student student) {
		Optional<Student> studentByEmail =
				studentRepository.findStudentByEmail(student.getEmail());
		if(studentByEmail.isPresent()) {
			throw new IllegalStateException("Email taken");
		}
		studentRepository.save(student);
		System.out.println(student);
	}
	
	/**
	 * @param studentId is used to identify the student to be deleted from the db
	 */
	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if(!exists) {
			throw new IllegalStateException("Student with ID " + studentId + " does not exist");
		}
		studentRepository.deleteById(studentId);
	}
	/*
	 * @Transactional annotation means you can use the entity to check whether you
	 * can or cannot update the value of an attribute, and then use the setters from
	 * the entity to automatically update it without writing a JPQL query.
	 */
	
	/**
	 * @param studentId will be used to search for the student in the db
	 * Basic validation is used to make sure the student exists or throw an exception if not
	 * @param name is the new name for the student 
	 * @param email is the new email for the student
	 * Additional checks are done to make sure the user has entered a valid name and email
	 */
	@Transactional 
	public void updateStudent(Long studentId, 
							  String name, 
							  String email) {
		Student student = studentRepository.findById(studentId).orElseThrow(
				() -> new IllegalStateException(
						"StudentId: " + studentId + " does not exist"));
		if(name != null && name.length() > 0 && 
				!Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		if(email != null && email.length() > 0 &&
				!Objects.equals(student.getEmail(), email)) {
			student.setEmail(email);
		}
		
	}

}
