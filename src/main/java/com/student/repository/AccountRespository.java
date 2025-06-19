package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.Accounts;

public interface AccountRespository extends JpaRepository<Accounts, String> {

}
