package com.app.springbootstarter.Topics;

import org.springframework.data.repository.CrudRepository;

//here we have extended CrudRepository as it has generic common methods to perform basic CRUD operations
//also we have passed Topic and Integer as generic since it can accept that kind of class
public interface TopicRepository extends CrudRepository<Topic,Integer>{

}
