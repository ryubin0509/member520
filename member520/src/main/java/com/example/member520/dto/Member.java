package com.example.member520.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Member {
	private String id;
	private String pw;
	private String email;
	private String active;
	private LocalDateTime lastLogin;
}
