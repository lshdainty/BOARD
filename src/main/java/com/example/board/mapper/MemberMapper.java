package com.example.board.mapper;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;
import com.example.board.domain.MemberVO;

public interface MemberMapper {
	public ArrayList<MemberVO> selectMember(@Param("id")String id);  // 로그인 하기 위한 쿼리
}
