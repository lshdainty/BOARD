package com.example.board.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.example.board.domain.PostVO;

public interface PostService {
	public ArrayList<PostVO> getPostList();  // 게시판에 모든 글 목록 불러오기
	
	public PostVO getPostPage(String post_code); //세부 게시글 내용 불러오기
	
	public int insertPost(PostVO post);  // 글 작성
	
	public int updatePost(PostVO post); // 게시글 업데이트(수정)
	
	public int deletePost(int post_code);  // 글 삭제
}
