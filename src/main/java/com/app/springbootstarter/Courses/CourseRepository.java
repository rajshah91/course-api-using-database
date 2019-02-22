package com.app.springbootstarter.Courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//here we have extended CrudRepository as it has generic common methods to perform basic CRUD operations
//also we have passed Topic and Integer as generic since it can accept that kind of class
public interface CourseRepository extends CrudRepository<Course,Integer>{
	
	
	//We don't need to implement the method. Just declare the method with the findByProperty (here : name) format
	// and Spring Data JPA will automatically implement the methods for you on runtime 
	
	public List<Course> findByName(String name);
	
	public List<Course> findByDescription(String description);
	
	public List<Course> findByTopicId(int topicId);
}
