package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC {
//	public static void main(String[] args) {
		@RequestMapping("/getYoilMVC")
//		public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		public String main(int year, int month, int day, Model model) throws IOException {
		// 1. 입력
//		String year = request.getParameter("year");
//		String month = request.getParameter("month");
//		String day = request.getParameter("day");
		
		// 2. 작업
//		int yyyy = Integer.parseInt(year);
//		int mm = Integer.parseInt(month);
//		int dd = Integer.parseInt(day);
		
			// 1. 유효성 검사
			if(!isValid(year, month, day))
				return "yoilError";
			
			// 2. 요일 계산
			char yoil = getYoil(year, month, day);
			
			// 3. 계산한 결과를 model에 저장
			model.addAttribute("year", year);
			model.addAttribute("month", month);
			model.addAttribute("day", day);
			model.addAttribute("yoil", yoil);
			
		return "yoil"; // /WEB-INF/views/yoil.jsp
	
		// 3. 출력
//		response.setContentType("text/html"); // 브라우저는 응답하는 값이 text 인지 binary인지 알수 없다. 따라서 text임을 알려줘야 한다.
//		response.setCharacterEncoding("utf-8"); // 인코딩해줘야 한글이 깨지지 않는다.
//		PrintWriter out = response.getWriter(); // response 객체에서 브라우저의 출력 스트림을 얻는다.
//		out.println(year + "년" + month + "월 " + day + "일은 ");
//		out.println(yoil + "요일입니다.");
	}

	private boolean isValid(int year, int month, int day) {
	// TODO Auto-generated method stub
	return true;
}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
	//		cal.set(yyyy, mm - 1, dd);
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1: 일요일, 2: 월요일 ...
		return "일월화수목금토".charAt(dayOfWeek-1);
	}
}
