package com.itwillbs.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 컨트롤러로 사용할 수 있도록 준비
public class SampleController2 {

	
		// 해당 컨트롤러의 정보를 로그로 출력하기 위한 준비 
	private static final Logger log = 
			LoggerFactory.getLogger(SampleController2.class);
	
	// [/doC]주소를 통해서 처리 하는 메서드 doC() 구현
	// 도착정보를 로그로 출력 
	
	@RequestMapping("/doC")
	public String doC(@ModelAttribute("msg")  String msg, @ModelAttribute("age")  int age ) { // 다른데로 이동시키려면
		
		// @ModelAttribute("이름") // 자동으로 해당 데이터를 뷰페이지 까지 이동 
		
	log.info("doC()메서드 호출 !!!!!!!!!!!!!!!!!");
	return "itwill" ; // 이 리턴에 따라  jsp파일인지 찾음, 좀 희안하게 되있네
	// 리턴값 없으면 requestmapping 대로 jsp 찾음
	}
	
	// * 메서드의 리턴타입이 String 일경우 리턴값.jsp 호출
	
	// doC1 주소를 통해서 itwill.jsp (view)페이지 이동 
	@RequestMapping("/doC1")
	public String doC1() {
		log.info("doC1()메서드 호출 itwill.jsp 이동");
		return "itwill";
	}
}
