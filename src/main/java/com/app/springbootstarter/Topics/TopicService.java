package com.app.springbootstarter.Topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	

	public List<Topic> getAllTopics(){
//		return (List<Topic>) topicRepository.findAll();
		
		List<Topic> topics=new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics :: add);
		return topics;
	}

	public Optional<Topic> getTopic(int id) {
		return topicRepository.findById(id);
	}

	public Topic addTopic(Topic topic) {
		return topicRepository.save(topic);
//		System.out.println("Topic Added");
	}
	
	public Topic updateTopic(Topic topic) {
		return topicRepository.save(topic);
//		System.out.println("Topic Updated");
	}

	public void deleteTopic(int id) {
		topicRepository.deleteById(id);
		System.out.println("Topic Deleted");
	}

}
