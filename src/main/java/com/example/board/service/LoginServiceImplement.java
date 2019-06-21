package com.example.board.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import com.example.board.domain.MemberVO;
import com.example.board.mapper.MemberMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginServiceImplement implements LoginService{
	private MemberMapper memberMapper;

	@Override
	public ArrayList<MemberVO> selectMember(String id) {
		return memberMapper.selectMember(id);
	}
}