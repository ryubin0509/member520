package com.example.member520.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.member520.dto.ChangePassword;
import com.example.member520.dto.Member;
import com.example.member520.dto.PwHistory;

@Mapper
public interface LoginMapper {
	 int checkLogin(Member paramMember);  //  로그인 동작 
	 int insertLoginHistory(Member paramMember); // 로그인 정보 삽입
	 List<Member> loginExpire(); // 로그인 만료정보를 담는다.
	 void updateActive(String id); // id 상태 업데이트
	 Member selectId(String id); // id 관련된 패스워드를 받는다.
	 void updatePassword(ChangePassword changePassword); // password 변경
	 int checkPassword(PwHistory pwhistory); // pwhistory에 기록이 있는지 확인
	 int insertPwHistory(PwHistory pwhistory); // Pwhistory 에 기록 삽입
	 void deletePassWordHistory();// 최근 5개 password 를 제외한 나머지기록 삭제
}
