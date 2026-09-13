package com.lms.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.cms.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
