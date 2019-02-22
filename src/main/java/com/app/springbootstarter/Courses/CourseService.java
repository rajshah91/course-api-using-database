package com.app.springbootstarter.Courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourse(int topicId) {
		List<Course> courses=new ArrayList<Course>();
		/////////Important
		courseRepository.findByTopicId(topicId).forEach(courses :: add);
		return courses;
	}

	public Optional<Course> getCourse(int courseid) {
		return courseRepository.findById(courseid);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourse(int courseid) {
		courseRepository.deleteById(courseid);
	}

}
