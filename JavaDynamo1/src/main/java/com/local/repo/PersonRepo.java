package com.local.repo;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.local.entity.Person;

@Repository
public class PersonRepo {
	
	@Autowired
	private DynamoDBMapper mapper;
	
	public Person addPerson(Person person) {
		System.out.println("Person added...");
		mapper.save(person);
		return person;
	}
	public Person getPersonById(String personId) {
		System.out.println("Get request for "+personId);
		return mapper.load(Person.class,personId);
	}
	
	public String deletePerson(Person person) {
		System.out.println("Delete request for "+person.getPersonId());
		mapper.delete(person);
		return "Deleted";
	}
	public String updatePerson(Person person) {
		mapper.save(person, buildExpr(person));
		return "Record updared";
	}
	private DynamoDBSaveExpression buildExpr(Person person) {
		
		DynamoDBSaveExpression expr = new DynamoDBSaveExpression();
		Map<String,ExpectedAttributeValue> exMap = new HashMap<>();
		exMap.put("personId", new ExpectedAttributeValue(new AttributeValue()
				.withS(person.getPersonId())));
		expr.setExpected(exMap);
		return expr;
		
	}

}
