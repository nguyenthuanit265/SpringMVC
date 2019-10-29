package com.myclass.service.impl;

import org.springframework.stereotype.Service;

import com.myclass.entity.Course;
import com.myclass.service.CourseService;

@Service
public class CoursesServiceImpl extends GenericServiceImpl<Course, Integer> implements CourseService {
//	@Autowired
//	CourseRepository courseRepository;
//
//	public List<Course> findAll() {
//		// TODO Auto-generated method stub
//		return courseRepository.FindAll();
//	}
//
//	public void add(Course course) {
//		course.setId(courseRepository.FindAll().size() + 1);
//		courseRepository.SaveOrUpdate(course);
//	}
//
//	public Course findById(int id) {
//		// TODO Auto-generated method stub
//		return courseRepository.FindById(id);
//	}
//
//	public void update(Course course) {
//		// TODO Auto-generated method stub
//		courseRepository.SaveOrUpdate(course);
//	}
//
//	public void removeById(int id) {
//		// TODO Auto-generated method stub
//		courseRepository.RemoveById(id);
//	}

}
