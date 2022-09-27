package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//모든 콘트롤러의 예외처리에 작동하는 매서드
//@ControllerAdvice // 모든 패키지에 적용
@ControllerAdvice("com.fastcampus.ch2") // 지정된 패키지에서 발생한 예외만 처리
public class GlobalCatcher {
		@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
		public String catcher2(Exception ex, Model m) {
			m.addAttribute("ex", ex);
			return "error";
		}
		@ExceptionHandler(Exception.class)
		public String catcher(Exception ex, Model m) {
			m.addAttribute("ex", ex);
			return "error";
		}
}
