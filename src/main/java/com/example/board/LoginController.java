package com.example.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.board.service.LoginService;

import lombok.AllArgsConstructor;

/**
 * Handles requests for the application home page.
 */
@Controller
@AllArgsConstructor
public class LoginController {
	private LoginService loginService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String test(Model model) {
		String memberName = loginService.selectMember();
		
		model.addAttribute("member",memberName);
		return "home";
	}
}