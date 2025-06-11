package com.nsk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsk.binding.Course;
import com.nsk.repo.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {

	
	@Autowired
	private CourseRepo courseRepo;
	
	@Override
	public String upsert(Course course) {
		courseRepo.save(course);
		return "success";
		
	}

	@Override
	public Course getByID(Integer cid) {

		Optional<Course> findById  = courseRepo.findById(cid);
		
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		
		return courseRepo.findAll();
		
	}

	@Override
	public String deleteById(Integer cid) {
                
		if(courseRepo.existsById(cid)) {
			courseRepo.deleteById(cid);
			return "success";
		}else {
			return "no record found";
		}
	}
	
}
