package com.student.service;

import java.util.List;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.entity.Accounts;

public interface StudentService {
	List<StudentResponse> createStudent(StudentRequest request);

	List<StudentResponse> updateStudent(StudentRequest request);

	List<StudentResponse> deleteStudent(String StudentId);

}
