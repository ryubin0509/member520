package com.example.member520.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.member520.dto.Member;
import com.example.member520.service.ILoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired ILoginService loginService;
	
	@GetMapping({"/","login"})
	public String loigin() {
		return "/login";
	}
	
	
	@PostMapping("login")
	public String login1(Member paramMember,HttpSession session ) {
		  int row =  loginService.checkLogin(paramMember);	
		 if(row == 1) {
			 session.setAttribute("id", paramMember.getId());
			 return "/loginSuccess";  // 로그인 성공 화면
		 } else { 
			 return "/login"; //  로그인 실패시  로그인 화면
		 }
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate(); // 세션 무효화 (모든 정보 삭제)
	    return "redirect:/login"; // 로그인 페이지로 리다이렉트
	}
	
	
}
