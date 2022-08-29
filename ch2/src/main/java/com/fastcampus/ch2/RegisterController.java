package com.fastcampus.ch2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
//	@RequestMapping(value="/register/save", method={RequestMethod.GET, RequestMethod.POST})
//	@RequestMapping("/register/add")
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm";
//	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")
	public String save(User user, Model model) throws Exception {
		// 1. 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");
			return "redirect:/register/add?msg="+msg; // URL재작성(rewriting)
		}
		
		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}
	
	private boolean isValid(User user) {
		return false;
	}
	
	
}
