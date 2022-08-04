package com.example.demo.student;

import static java.time.Month.APRIL;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*@Configuration indicates that the class has @Bean definition methods
Spring container can process the class and generate Spring Beans.
@Bean annotation ensures the CommandLineRunner will run.
Inject StudentRepository into the commandLineRunner so we can access it.
CommandLineRunner is an interface that will automatically call the run method of all 
the beans implementing this interface, after app context is loaded. */

@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository repository){
		return args -> {
			// id attribute will be added automatically by db sequence
			Student tony = new Student(
					"Tony",
					"Soprano@sopranomail.com",
					LocalDate.of(2000, APRIL, 20),
					22
					);
			Student silvio = new Student(
					"Silvio",
					"Dante@sopranomail.com",
					LocalDate.of(2002, APRIL, 20),
					20
					);
			repository.saveAll(
					List.of(tony, silvio)
					);
			
		};
	};
	
}
