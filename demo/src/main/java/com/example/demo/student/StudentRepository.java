package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
XRepository is the naming convention used for data access layers.
JpaRepository needs to specify the type of object and the PK type, so
Student object with a long type variable for the primary key will be used for this repository.
@Repository annotation indicates that the class provides the mechanism for storage, retrieval, 
update, delete and search operation on objects.
*/

@Repository 
public interface StudentRepository
	extends JpaRepository<Student, Long> {

}
