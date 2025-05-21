package com.example.member520.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.member520.Schedul.MySchedule;
import com.example.member520.dto.Member;
import com.example.member520.mapper.LoginMapper;

import jakarta.mail.Transport;
import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class LoginService implements ILoginService {
	@Autowired LoginMapper loginMapper;
	@Autowired JavaMailSender javaMailSender;
	
	
	@Override
	public void loginExpire() {
	List<Member> dormantMembers = loginMapper.loginExpire();
	
	for(Member member: dormantMembers) {
		updateActive(member.getId());
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("admin@gmail.com");
		msg.setTo(member.getEmail());
		msg.setSubject("휴먼상태입니다.");
		msg.setText(member.getId()+"님 1년동안 활동이 중지되어 휴먼처리 됩니다.");
		
		javaMailSender.send(msg);
	}
	
	
	}

	
	
	public int checkLogin(Member paramMember) {
		int row =  loginMapper.checkLogin(paramMember);
		if(row == 1) {
			log.info("로그인 기록 저장");
			 return insertLoginHistory(paramMember);	
		}
		else {
			log.info("로그인 저장 실패");
			return 0;
			
		}
		 
	}
	
	public int insertLoginHistory(Member paramMember) {
		return loginMapper.insertLoginHistory(paramMember);
			
	}


	@Override
	public void updateActive(String id) {
		// TODO Auto-generated method stub
		loginMapper.updateActive(id);
	}

	
	

}
