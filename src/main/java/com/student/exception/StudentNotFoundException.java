package com.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

}
