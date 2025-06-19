package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.constants.StudentValidator;
import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.entity.Accounts;
import com.student.entity.Student;
import com.student.exception.StudentNotFoundException;
import com.student.repository.AccountRespository;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private AccountRespository accountsRepository;

	@Override
	public List<StudentResponse> createStudent(StudentRequest request) {
		// TODO Auto-generated method stub
		// create first Account
		Accounts accounts = new Accounts();
		accounts.setAccNo(request.getAccounts().getAccNo());
		accounts = accountsRepository.save(accounts);

		// cretae a student
		Student student = new Student();
		student.setSname(request.getName());
		student.setEmail(request.getEmail());
		student.setPhone(request.getPhone());
		student.setAccounts(accounts);
		student = studentRepository.save(student);
		// prepare a response
		StudentResponse response = new StudentResponse();
		response.setSid(student.getSid());
		response.setName(student.getSname());
		response.setEmail(student.getEmail());
		response.setAccNo(student.getAccounts().getAccNo());
		response.setMessage(StudentValidator.Message_201);

		return List.of(response);
	}

	@Override
	public List<StudentResponse> updateStudent(StudentRequest request) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(Integer.parseInt(request.getId()))
				.orElseThrow(() -> new StudentNotFoundException("Student Not Found" + request.getId()));

		student.setSname(request.getName());
		student.setEmail(request.getEmail());
		student.setPhone(request.getPhone());

		if (request.getAccounts() != null) {
			Accounts account = student.getAccounts();
			account.setAccNo(request.getAccounts().getAccNo());
			accountsRepository.save(account);

		}
		student = studentRepository.save(student);
		// response of student
		StudentResponse response = new StudentResponse();
		response.setSid(student.getSid());
		response.setName(student.getSname());
		response.setEmail(student.getEmail());
		response.setAccNo(student.getAccounts().getAccNo());
		response.setMessage(StudentValidator.Message_201);

		return List.of(response);
	}

	@Override
	public List<StudentResponse> deleteStudent(String StudentId) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(Integer.parseInt(StudentId))
				.orElseThrow(() -> new StudentNotFoundException("Student not found to delete with id" + StudentId));
		studentRepository.delete(student);
		// Student Response
		StudentResponse response = new StudentResponse();
		response.setMessage("Student Deleted Sucessfully");
		response.setSid(student.getSid());

		return List.of(response);
	}

}
