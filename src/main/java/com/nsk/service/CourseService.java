package com.nsk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nsk.binding.Course;

@Service
public interface CourseService {

	
    public String upsert(Course course);//insert update
	
	public Course getByID(Integer cid);
	
	public List<Course> getAllCourses();
	
	public String deleteById(Integer cid);

}
