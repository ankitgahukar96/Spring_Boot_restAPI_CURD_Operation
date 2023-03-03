package com.example.demo.controller;

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

import com.example.demo.services.CourseService;



@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/")
	public String home() {
		
		return "this is home page";
	}
	
	//get all courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		return this.courseService.getCourses();
	}
	
	//get course by ID
	@GetMapping("/courses/{courseID}")
	public Course getCourse(@PathVariable String courseID) {
		
		return this.courseService.getCourse(Long.parseLong(courseID));
	}
	
	//add courses
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.courseService.addCourse(course);
	}
	
	//update course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}

	//delete
	@DeleteMapping("/courses/{courseID}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseID) {
		try {
			this.courseService.deleteCourse(Long.parseLong(courseID));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
