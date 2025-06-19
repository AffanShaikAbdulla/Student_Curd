package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentRestController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/api/student")
	public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest req) {
		List<StudentResponse> response = studentService.createStudent(req);
		return new ResponseEntity(response, HttpStatus.CREATED);

	}

}
