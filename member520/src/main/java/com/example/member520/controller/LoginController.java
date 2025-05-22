package com.example.member520.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.member520.dto.ChangePassword;
import com.example.member520.dto.Member;
import com.example.member520.dto.PwHistory;
import com.example.member520.service.ILoginService;
import com.example.member520.service.LoginService;
import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {

	@Autowired ILoginService loginService;



	@GetMapping({"/","login"})
	public String loigin() {
		return "/login/login";
	}
	
	
	@PostMapping("login")
	public String login1(Member paramMember,HttpSession session ) {
		  int row =  loginService.checkLogin(paramMember);	
		 if(row == 1) {
			 session.setAttribute("id", paramMember.getId());
			 return "/login/loginSuccess";  // 로그인 성공 화면
		 } else { 
			 return "/login/login"; //  로그인 실패시  로그인 화면
		 }
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate(); // 세션 무효화 (모든 정보 삭제)
	    return "redirect:login"; // 로그인 페이지로 리다이렉트
	}
	
	@GetMapping("/changePw")
	public String changePw(HttpSession session) {
		return "/login/changePw";
	}
	
	@PostMapping("/changePw")
	@ResponseBody
	public Map<String,String> changePw(HttpSession session, @RequestParam String currentPw, @RequestParam String newPw) {
	 String id = (String) session.getAttribute("id");
	 
	 Map<String, String> result = new HashMap<>();
	 
	 Member member = loginService.selectId(id);
	 if(!member.getPw().equals(currentPw)){
		 result.put("message", "현재 비밀번호가 틀렸습니다.");
		 result.put("redirectUrl", "/changePw");
		 return result;
	 }
	 
	 PwHistory pwHistory = new PwHistory();
	 
	 pwHistory.setId(id);
	 pwHistory.setPw(newPw);
	 int row = loginService.checkPassword(pwHistory);
	 if(row != 0) {
		 result.put("message", "현재 비밀번호가 pwHistory에 있습니다.");
		 result.put("redirectUrl", "/changePw");
		 return result;
	 }
	 
	 
	 ChangePassword changePassword = new ChangePassword();
	 changePassword.setId(id);
	 changePassword.setCurrentPw(currentPw);
	 changePassword.setNewPw(newPw);
		
	 loginService.updatePassword(changePassword);
	 loginService.insertPwHistory(pwHistory);
	 	
	
		result.put("message", "비밀번호 변경성공");
	 	result.put("redirectUrl", "login");
	 	return result;
	
	}
}
