package com.example.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.example.board.domain.PostVO;

public interface PostMapper {
	public ArrayList<PostVO> getPostList();  // 게시판에 모든 글 목록 불러오기
	
	public PostVO getPostPage(@Param("post_code")String post_code); //세부 게시글 내용 불러오기
	
	public int insertPost(PostVO post);  // 글 작성
	
	public int updatePost(PostVO psot); // 게시글 업데이트(수정)
	
	public int deletePost(@Param("post_code")int post_code);  // 글 삭제
}
