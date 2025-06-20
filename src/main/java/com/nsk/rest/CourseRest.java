package com.nsk.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nsk.binding.Course;
import com.nsk.service.CourseService;

@RestController
public class CourseRest {
	
	@Autowired
	private CourseService courseService;
	
	
	@GetMapping("/test")
    public String hello() {
        return "Hello, World!";
    }
	
	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody Course course) {
		
		String status = courseService.upsert(course);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/course/{cid}")
	public ResponseEntity<Course> getCourse(@PathVariable Integer cid){
		Course course = courseService.getByID(cid);
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses() {
	    List<Course> allCourses = courseService.getAllCourses();
	    return new ResponseEntity<>(allCourses, HttpStatus.OK);
	}

	
	@PutMapping("/course")
	public ResponseEntity<String> updateCourse(@RequestBody Course course){
	  String status = courseService.upsert(course);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@DeleteMapping("/course/{cid}")
	public ResponseEntity<String> deleteCourse(@PathVariable Integer cid){
	  String status = courseService.deleteById(cid);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
}
