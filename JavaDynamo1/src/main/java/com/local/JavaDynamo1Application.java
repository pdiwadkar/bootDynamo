package com.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.local.entity.Person;
import com.local.repo.PersonRepo;

@SpringBootApplication
@RestController
public class JavaDynamo1Application {
	/*
	 * SpringBoot and aws DynamoDb
	 */
	@Autowired
	private PersonRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(JavaDynamo1Application.class, args);
	}
	@PostMapping("/savePerson")
	public Person savePerson(@RequestBody Person person) {
		return repo.addPerson(person);  
	}
	
	@GetMapping("/getPerson")
	public Person getPerson(@PathVariable String personId) {
		return repo.getPersonById(personId);
	}
	
	@DeleteMapping("/deletePerson")
	public String deletePerson(@RequestBody Person person) {
		return repo.deletePerson(person);
	}
	@PutMapping("/updatePerson")
	public String updatePerson(@RequestBody Person person) {
		return repo.updatePerson(person);
	}
	
	
	
	

}
