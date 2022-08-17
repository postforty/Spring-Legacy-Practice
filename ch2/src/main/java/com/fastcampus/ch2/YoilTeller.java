package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 실행 방법 : C:\Users\J\Documents\GitHub\Spring-Legacy-Practice\ch2\target\classes>java com.fastcampus.ch2.YoilTeller 2021 10 1

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTeller {
//	public static void main(String[] args) {
		@RequestMapping("/getYoil")
		public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		// 2. 작업
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm - 1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1: 일요일, 2: 월요일 ...
		char yoil = "일월화수목금토".charAt(dayOfWeek-1);
		
	
		// 3. 출력
		response.setContentType("text/html"); // 브라우저는 응답하는 값이 text 인지 binary인지 알수 없다. 따라서 text임을 알려줘야 한다.
		response.setCharacterEncoding("utf-8"); // 인코딩해줘야 한글이 깨지지 않는다.
		PrintWriter out = response.getWriter(); // response 객체에서 브라우저의 출력 스트림을 얻는다.
		out.println(year + "년" + month + "월 " + day + "일은 ");
		out.println(yoil + "요일입니다.");
	}
}
