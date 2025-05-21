package com.example.member520.Schedul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.member520.dto.Member;
import com.example.member520.service.ILoginService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MySchedule {
	@Autowired ILoginService loginService;
	
	@Scheduled(cron = "0 0 10 * * *")
	public void scheduleDormantCheck() {
		loginService.loginExpire();
	}
	
	

}
