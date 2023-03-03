package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.controller.Course;

public interface CoursesDAO extends JpaRepository<Course, Long> {

}
