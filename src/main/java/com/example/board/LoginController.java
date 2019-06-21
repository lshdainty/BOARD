package com.example.board;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.domain.MemberVO;
import com.example.board.service.LoginService;

import lombok.AllArgsConstructor;

/**
 * Handles requests for the application home page.
 */
@Controller
@AllArgsConstructor
public class LoginController {
	private LoginService loginService;
	
	/* 제일 첫 화면  */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		
		return "home";
	}
	
	
	/* 로그인  */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public int login(@RequestParam String id, @RequestParam String password, HttpSession session) {
		ArrayList<MemberVO> member = loginService.selectMember(id);

		if(member.size() > 0) {     						//select 의 결과가 있을때 실행
			if(id.equals(member.get(0).getId())) {			//select 의 결과가 있다면 들고온값과 입력받은 값 비교
				if(password.equals(member.get(0).getPw())) { // 아이디가 일치할때 비밀번호 확인
					session.setAttribute("id" , member.get(0).getId());
					return 0;  //로그인 성공
				}else {
					return 2; //비밀번호 틀림
				}
			}
		}

		return 1; //아이디 없음
	}
	
}