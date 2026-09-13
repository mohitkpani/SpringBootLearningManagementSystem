package com.lms.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lms.cms.dto.CourseRequestDTO;
import com.lms.cms.dto.CourseResponseDTO;
import com.lms.cms.entity.Course;
import com.lms.cms.exception.CourseNotFoundException;
import com.lms.cms.repository.CourseRepository;

@Service
public class CourseService {
	
	private final CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}
	
	private Course mapToEntity(CourseRequestDTO dto) {
		Course course = new Course();
		course.setName(dto.name());
		course.setDescription(dto.description());
		course.setPrice(dto.price());
		return course;
	}
	
	private CourseResponseDTO mapToResponseDTO(Course course) {
		return new CourseResponseDTO(
				course.getId(),
				course.getName(),
				course.getDescription(),
				course.getPrice()
				);
	}
	
	//ADD COURSE
	public CourseResponseDTO createCourse(CourseRequestDTO course) {
		Course createdCourse = courseRepository.save(mapToEntity(course));
		return mapToResponseDTO(createdCourse);
	}
	
	//GET COURSE BY ID
	public CourseResponseDTO getCourseById(Long id) {
		Course course = courseRepository.findById(id)
				.orElseThrow(() -> new CourseNotFoundException(
						"No Course found with the id : " + id
						));
		return mapToResponseDTO(course);
	}
	
	//GET ALL COURSES
	public List<CourseResponseDTO> getAllCourses(){
		List<Course> CourseList = courseRepository.findAll();
		return CourseList.stream().map(this::mapToResponseDTO).toList();
	}
	
	//PARTIAL UPDATE
	public CourseResponseDTO updateCoursePartially(Long id, CourseRequestDTO updatedCourse) {
		Course existingCourse = courseRepository.findById(id).get();
		
		if(updatedCourse.name() != null)
			existingCourse.setName(updatedCourse.name());
		
		if(updatedCourse.description() != null)
			existingCourse.setDescription(updatedCourse.description());
		
		
		if(updatedCourse.price() != 0)
			existingCourse.setPrice(updatedCourse.price());
		
		 Course savedCourse = courseRepository.save(existingCourse);
		 return mapToResponseDTO(savedCourse);
		
	}
	
	//FULL UPDATE
	public CourseResponseDTO updateCourseFully(Long id, CourseRequestDTO updatedCourse) {
		Course existingCourse = courseRepository.findById(id).get();
		
		existingCourse.setName(updatedCourse.name());
		existingCourse.setDescription(updatedCourse.description());
		existingCourse.setPrice(updatedCourse.price());
		
		Course updatedCourses = courseRepository.save(existingCourse);
		return mapToResponseDTO(updatedCourses);
	}

	//DELETE COURSE
	public String deleteCourse(Long id) {
		 courseRepository.deleteById(id);
		 return "Course deleted successfully";
		
	}
	
	
	
	
	
	
}
