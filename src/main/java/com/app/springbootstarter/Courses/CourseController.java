package com.app.springbootstarter.Courses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.springbootstarter.Topics.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourse(@PathVariable("id") int topicId){
		return courseService.getAllCourse(topicId);
	}
	
	@RequestMapping("/topics/{id}/courses/{courseid}")
	public Optional<Course> getCourse(@PathVariable("courseid") int courseid) {
		return courseService.getCourse(courseid);
	}
	
	@RequestMapping(value="/topics/{id}/courses/",method=RequestMethod.POST)
	public void addCourse(@RequestBody Course course,@PathVariable("id") int topicId) {
		
		//this is important and tricky part
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(value="/topics/{id}/courses/",method=RequestMethod.PUT)
	public void updateCourse(@RequestBody Course course,@PathVariable("id") int topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(value="/topics/{id}/courses/{courseid}",method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable("courseid") int courseid) {
		courseService.deleteCourse(courseid);
	}
     
}
