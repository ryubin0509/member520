package com.example.member520.service;

import java.nio.channels.Channel;
import java.util.List;
import java.util.Map;

import com.example.member520.dto.ChangePassword;
import com.example.member520.dto.Member;
import com.example.member520.dto.PwHistory;

public interface ILoginService {

	
	int insertLoginHistory(Member paramMember);
	int insertPwHistory(PwHistory pwhistory);
	int checkLogin(Member paramMember);
	int	checkPassword(PwHistory pwhistory);
	
	void loginExpire();
	void updateActive(String id);
	void updatePassword(ChangePassword changePassword);
	
	void deletePassWordHistory();
	 	 
	
	Member selectId(String id);
	
}
