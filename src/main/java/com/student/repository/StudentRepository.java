package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.entity.Accounts;
import com.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
