package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.Course;
import com.example.demo.dao.CoursesDAO;

@Service
public class CourseServiceIml implements CourseService {

	@Autowired
	private CoursesDAO courseDao;
//	List<Course> list;
	
	public CourseServiceIml() {
		// TODO Auto-generated constructor stub
//		list=new ArrayList<>();
//		list.add(new Course(1, "Java", "Object Oriented programming"));
//		list.add(new Course(2, "React", "web base programming"));
//		list.add(new Course(3, "MySQL", "Database Managment"));
	}
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
//		return list;
		return courseDao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Course getCourse(long courseID) {
		// TODO Auto-generated method stub
//		Course c = null;
//		
//		for(Course course : list) {
//			if(course.getId()==courseID) {
//				c = course;
//				break;
//			}
//		}
//		return c;
		
		return courseDao.getOne(courseID);
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
//		list.add(course);
//		return course;
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
//		list.forEach(e -> {
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
//		return course;
		
		courseDao.save(course);
		return course;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
//		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Course entity=courseDao.getOne(parseLong);
		courseDao.delete(entity);
		
	}

}
