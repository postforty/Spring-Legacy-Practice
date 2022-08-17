package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. 원격 호출가능한 프로그램으로 등록
@Controller
public class Hello {
	
	int iv = 10; // 인스턴스 변수
	static int cv = 20; // static 변수
	
	// 2. URL과 메서드를 연결
	@RequestMapping("/hello")
	private void main() { // 인스턴스 메서드 - iv, cv를 둘다 사용가능하므로 static 메서드 대신 사용하는 것이 유리
		System.out.println("Hello - private"); // 접근제어자 private이더라도 @RequestMapping으로 인해 접근 가능
		System.out.println("cv"); // OK
		System.out.println("iv"); // OK
	}
	
	public static void main2() {
		System.out.println(cv); // OK
//		System.out.println(iv); // error
	}

}
