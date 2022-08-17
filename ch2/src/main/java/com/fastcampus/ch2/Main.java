package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main(); // private이라서 외부 호출 불가
		
		// Hello.java에서 호출된 이유는,
		// Reflection API를 사용 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능제공
		// java.lang.reflect패키지를 제공
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance(); // Class 객체가 가진 정보로 객체 생성
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); // private인 main()을 호출 가능하게 한다.
		
		main.invoke(hello); // hello.main()
 	}
}
