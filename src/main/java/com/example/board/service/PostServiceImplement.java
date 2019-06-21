package com.example.board.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.board.domain.PostVO;
import com.example.board.mapper.PostMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostServiceImplement implements PostService{
	private PostMapper postMapper;
	
	@Override
	public ArrayList<PostVO> getPostList() {
		// TODO Auto-generated method stub
		return postMapper.getPostList();
	}
	
	@Override
	public PostVO getPostPage(String post_code) {
		// TODO Auto-generated method stub
		return postMapper.getPostPage(post_code);
	}
	
	@Override
	public int insertPost(PostVO post) {
		// TODO Auto-generated method stub
		return postMapper.insertPost(post);
	}
	
	@Override
	public int updatePost(PostVO post) {
		// TODO Auto-generated method stub
		return postMapper.updatePost(post);
	}
	
	@Override
	public int deletePost(int post_code) {
		// TODO Auto-generated method stub
		return postMapper.deletePost(post_code);
	}
}
