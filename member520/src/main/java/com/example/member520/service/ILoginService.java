package com.example.member520.service;

import java.util.List;
import java.util.Map;

import com.example.member520.dto.Member;

public interface ILoginService {

	
	int insertLoginHistory(Member paramMember);
	int checkLogin(Member paramMember);
	
	void loginExpire();
	void updateActive(String id);

}
