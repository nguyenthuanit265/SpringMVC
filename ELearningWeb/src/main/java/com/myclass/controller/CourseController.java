package com.myclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.entity.Course;
import com.myclass.service.CourseService;

@RestController
@RequestMapping("api/course")
public class CourseController {
	@Autowired
	CourseService courseService;

	@GetMapping("")
	public ResponseEntity<List<Course>> get() {
		List<Course> list = courseService.findAll();

		return new ResponseEntity(list, HttpStatus.OK);
	}
}
