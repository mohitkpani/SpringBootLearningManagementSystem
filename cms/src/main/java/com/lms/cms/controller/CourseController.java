package com.lms.cms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity <CourseResponseDTO> createCourse(@Valid @RequestBody CourseRequestDTO course) {
		 CourseResponseDTO courseCreated = courseService.createCourse(course);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(courseCreated);
		
	}
	
	//GET COURSE BY ID
	@GetMapping("/{id}")
	public ResponseEntity <CourseResponseDTO> getCourseById(@PathVariable Long id) {
		return ResponseEntity.ok(courseService.getCourseById(id));
	}
	
	//GET ALL COURSES
	@GetMapping
	public List<CourseResponseDTO> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	//PARTIAL UPDATE
	@PatchMapping("/{id}")
	public ResponseEntity <CourseResponseDTO> updateCoursePartially(@PathVariable Long id, @RequestBody CourseRequestDTO updatedCourse) {
		return ResponseEntity.ok (courseService.updateCoursePartially(id, updatedCourse));
	}
	
	//FULL UPDATE
	@PutMapping("/{id}")
	public ResponseEntity <CourseResponseDTO> updateCourseFully(@PathVariable Long id,@RequestBody CourseRequestDTO updatedCourse) {
		return ResponseEntity.ok(courseService.updateCourseFully(id, updatedCourse));
	}
	
	//DELETE COURSE
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
		 courseService.deleteCourse(id);
		 return ResponseEntity.noContent().build();
		 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
