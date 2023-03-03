package com.example.demo.services;

import java.util.List;

import com.example.demo.controller.Course;

public interface CourseService {

	public List<Course> getCourses();

	public Course getCourse(long courseID);

	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public void deleteCourse(long parseLong);
}
