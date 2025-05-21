package com.example.member520.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.member520.dto.Member;

@Mapper
public interface LoginMapper {
	 int checkLogin(Member paramMember);  //  로그인 동작 
	 int insertLoginHistory(Member paramMember); // 로그인 정보 삽입
	 List<Member> loginExpire(); // 로그인 만료정보를 담는다.
	 void updateActive(String id);
}
