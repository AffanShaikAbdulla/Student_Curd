package com.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
	private String id;
	private String name;
	private String email;
	private String phone;
	private AccountsRequest accounts;

}
