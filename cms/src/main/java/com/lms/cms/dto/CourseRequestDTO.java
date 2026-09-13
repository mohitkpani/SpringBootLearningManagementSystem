package com.lms.cms.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CourseRequestDTO(
		@NotBlank(message = "Course name is required.")
		@Size(min = 3, max = 100, message = "Name should be in 3 to 100 characters.")
		String name,
		
		@NotBlank(message = "Course description is required.")
		@Size(max = 50, message = "Description should be in between 50 characters.")
		String description,
		
		@NotNull(message = "Course price required.")
		@Min(value = 0, message = "Course price should be more than 0.")
		Integer price
		) {

}
