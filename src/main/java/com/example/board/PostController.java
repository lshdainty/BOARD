package com.example.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.domain.PostVO;
import com.example.board.service.PostService;

import lombok.AllArgsConstructor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@AllArgsConstructor
public class PostController {
	private PostService postService;
	
	///////////////////////////////////////////////////////////////////////////////
	
	/* 메인 게시글 이동 메소드 */
	@RequestMapping(value = "/viewMainPost", method = RequestMethod.GET)
	public String viewMainPost() {
		return "postListPage";
	}
	
	/* 게시글 목록 불러오기 메소드*/
	@RequestMapping(value = "/postList", method = RequestMethod.GET)
	public JSONObject postList() {
		
		Map<String, Object> map = new HashMap<String, Object>(); //  jsonobject 만들용
		ArrayList<PostVO> postList = postService.getPostList();  // 리스트 목록 불러오기
		
		JSONArray jPostList = JSONArray.fromObject(postList);
		
		map.put("result", jPostList);
		
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}
	
	///////////////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////////
	
	/* 세부 게시글  이동 메소드 */
	@RequestMapping(value = "/viewPostPage", method = RequestMethod.GET)
	public String viewPostPage() {
		return "postViewPage";
	}
	
	/* 세부 글 내용  불러오기 메소드*/ /* 글 수정을 위해 데이터를 불러오는 메소드로도 사용 */
	@RequestMapping(value = "/postPage"+"/{post_code}", method = RequestMethod.POST)
	public JSONObject postPage(@PathVariable String post_code) {
		
		Map<String, Object> map = new HashMap<String, Object>(); //  jsonobject 만들용
		PostVO postPage = postService.getPostPage(post_code);	//	게시글 내용 불러오기
		
		JSONArray jPostPage = JSONArray.fromObject(postPage);
		
		map.put("result", jPostPage);
		
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}
	
	///////////////////////////////////////////////////////////////////////////////
	
	
	///////////////////////////////////////////////////////////////////////////////
	
	/* 글 작성 이동 메소드 */ /* 글 수정 view이동을 위해 같이 사용  */
	@RequestMapping(value = "/viewWritePage", method = RequestMethod.GET)
	public String viewWritePage() {
		return "postWritePage";
	}
	
	/* 글 작성 메소드 */
	@RequestMapping(value = "/insertPost", method = RequestMethod.POST)
	public JSONObject insertPost(PostVO postVo, HttpSession session) {
		
		Map<String, Integer> map = new HashMap<String, Integer>(); //  jsonobject 만들용
		postVo.setId((String)session.getAttribute("id"));  //세선의 아이디를 작성자로 사용하기 위해서
		
		int checkNum = postService.insertPost(postVo); //  checkNum 이 1이면 성공  0이면 실패   
		
		map.put("result", checkNum);  
		
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}
	
	///////////////////////////////////////////////////////////////////////////////
	
	/* 글 수정 메소드  */
	@RequestMapping(value = "/updatePost", method = RequestMethod.POST)
	public JSONObject updatePost(PostVO postVo, HttpSession session) {
		
		Map<String, Integer> map = new HashMap<String, Integer>(); //  jsonobject 만들용
		
		if(!(postVo.getId().equals((String)session.getAttribute("id")))) {
			
			Map<String, String> err_map = new HashMap<String, String>(); //  err jsonobject 만들용
			
			err_map.put("result", "fail");  
			
			JSONObject json = JSONObject.fromObject(err_map);
			
			return json;
		}
		
		int checkNum = postService.updatePost(postVo); //  checkNum 이 1이면 성공  0이면 실패   
		
		map.put("result", checkNum);  
		
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}
	
	/* 글 삭제 메소드  */
	@RequestMapping(value = "/deletePost", method = RequestMethod.POST)
	public JSONObject deletePost(PostVO postVo, HttpSession session) {
		
		Map<String, Integer> map = new HashMap<String, Integer>(); //  jsonobject 만들용
		
		if(!(postVo.getId().equals((String)session.getAttribute("id")))) {
			
			Map<String, String> err_map = new HashMap<String, String>(); //  err jsonobject 만들용
			
			err_map.put("result", "fail");  
			
			JSONObject json = JSONObject.fromObject(err_map);
			
			return json;
		}

		int checkNum = postService.deletePost(postVo.getPost_code()); //  checkNum 이 1이면 성공  0이면 실패   
		
		map.put("result", checkNum);  
		
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}
}
