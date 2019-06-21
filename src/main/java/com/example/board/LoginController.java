package com.example.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.domain.MemberVO;
import com.example.board.domain.PostVO;
import com.example.board.service.LoginService;

import lombok.AllArgsConstructor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Handles requests for the application home page.
 */
@Controller
@AllArgsConstructor
public class LoginController {
	private LoginService loginService;
	
	/* 제일 첫 화면이동 메소드 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "logIn";
	}
	
	
	/* 로그인 메소드 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject login(@RequestParam String id, @RequestParam String password, HttpSession session) {
		ArrayList<MemberVO> member = loginService.selectMember(id);  //받아온 아이디로 db 쿼리
		Map<String, Integer> map = new HashMap<String, Integer>(); //jsonobject 만들용

		if(member.size() > 0) {     						//select 의 결과가 있을때 실행
			if(id.equals(member.get(0).getId())) {			//select 의 결과가 있다면 들고온값과 입력받은 값 비교
				if(password.equals(member.get(0).getPw())) { // 아이디가 일치할때 비밀번호 확인
					session.setAttribute("id" , member.get(0).getId());
					
					map.put("result",0);  //로그인 성공
				}else {
					map.put("result",2);  //비밀번호 틀림
				}
			}
		}else {
			map.put("result",1); //아이디 없음
		}
		
		
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}	
}