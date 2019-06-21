package com.example.board;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.board.domain.PostVO;
import com.example.board.service.PostService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PostController {
	private PostService postService;
	
	/* 게시글 목록 불러오기 */
	@RequestMapping(value = "/postList", method = RequestMethod.GET)
	public String postList(Model model) {
		
		ArrayList<PostVO> postList = postService.getPostList();
		
		model.addAttribute("postList", postList);
		
		return "postListPage";
	}
	
	/* 세부 글 내용  불러오기*/
	@RequestMapping(value = "/postPage"+"/{postCode}", method = RequestMethod.POST)
	public String postPage(Model model, @PathVariable String postCode) {
		
		PostVO postPage = postService.getPostPage(postCode);
		
		model.addAttribute("postPage", postPage);
		
		return "postListPage";
	}
	
	/* 글 작성 */
	@RequestMapping(value = "/insertPost", method = RequestMethod.POST)
	public String insertPost(Model model, PostVO postVo, HttpSession session) {
		
		postVo.setId((String)session.getAttribute("id"));
		
		postService.insertPost(postVo);
				
		return "postListPage";
	}
}
