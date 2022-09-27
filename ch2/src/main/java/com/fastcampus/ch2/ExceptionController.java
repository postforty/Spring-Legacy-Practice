package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	
//	// @ExceptionHandler는 해당 Controller 내에서만 사용 가능
//	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
//	public String catcher2(Exception ex, Model m) {
//		m.addAttribute("ex", ex);
//		return "error";
//	}
//	@ExceptionHandler(Exception.class)
//	public String catcher(Exception ex, Model m) {
//		m.addAttribute("ex", ex);
//		return "error";
//	}
	
	// GlobalCatcher.java에서 처리
	@RequestMapping("/ex")
	public String main(Model m) throws Exception {
		m.addAttribute("msg", "message from ExceptionController.main()");
		throw new Exception("예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex2")
	public String main2() throws Exception {
		throw new NullPointerException("예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex3")
	public String main3() throws Exception {
		throw new FileNotFoundException("예외가 발생했습니다.");
	}

}
