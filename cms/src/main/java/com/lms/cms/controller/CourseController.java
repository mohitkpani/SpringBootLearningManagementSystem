package com.lms.cms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.cms.dto.CourseRequestDTO;
import com.lms.cms.dto.CourseResponseDTO;
import com.lms.cms.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	@GetMapping("/check")
	public String check() {
		return "SO FAR SO GOOD";
	}
	
	//ADD COURSE
	@PostMapping
	public CourseResponseDTO createCourse(@Valid @RequestBody CourseRequestDTO course) {
		return courseService.createCourse(course);
	}
	
	//GET COURSE BY ID
	@GetMapping("/{id}")
	public CourseResponseDTO getCourseById(@PathVariable Long id) {
		return courseService.getCourseById(id);
	}
	
	//GET ALL COURSES
	@GetMapping
	public List<CourseResponseDTO> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	//PARTIAL UPDATE
	@PatchMapping("/{id}")
	public CourseResponseDTO updateCoursePartially(@PathVariable Long id, @RequestBody CourseRequestDTO updatedCourse) {
		return courseService.updateCoursePartially(id, updatedCourse);
	}
	
	//FULL UPDATE
	@PutMapping("/{id}")
	public CourseResponseDTO updateCourseFully(@PathVariable Long id,@RequestBody CourseRequestDTO updatedCourse) {
		return courseService.updateCourseFully(id, updatedCourse);
	}
	
	//DELETE COURSE
	@DeleteMapping("/{id}")
	public String deleteCourse(@PathVariable Long id) {
		 return courseService.deleteCourse(id);
		 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
