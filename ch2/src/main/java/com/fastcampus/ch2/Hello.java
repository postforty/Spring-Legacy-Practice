package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. ���� ȣ�Ⱑ���� ���α׷����� ���
@Controller
public class Hello {
	
	int iv = 10; // �ν��Ͻ� ����
	static int cv = 20; // static ����
	
	// 2. URL�� �޼��带 ����
	@RequestMapping("/hello")
	private void main() { // �ν��Ͻ� �޼��� - iv, cv�� �Ѵ� ��밡���ϹǷ� static �޼��� ��� ����ϴ� ���� ����
		System.out.println("Hello - private"); // ���������� private�̴��� @RequestMapping���� ���� ���� ����
		System.out.println("cv"); // OK
		System.out.println("iv"); // OK
	}
	
	public static void main2() {
		System.out.println(cv); // OK
//		System.out.println(iv); // error
	}

}
