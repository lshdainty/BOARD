package com.example.board.service;

import java.util.ArrayList;

import com.example.board.domain.MemberVO;

public interface LoginService {
	public ArrayList<MemberVO> selectMember(String id);  //로그인
}
