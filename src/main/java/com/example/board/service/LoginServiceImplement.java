package com.example.board.service;

import org.springframework.stereotype.Service;

import com.example.board.mapper.MemberMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginServiceImplement implements LoginService{
	private MemberMapper memberMapper;

	@Override
	public String selectMember() {
		return memberMapper.selectMember();
	}
}