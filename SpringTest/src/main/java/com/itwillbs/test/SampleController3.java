package com.itwillbs.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.ITWILLBean;

@Controller // 컨트롤러로 사용할 수 있도록 준비
public class SampleController3 {

	
		// 해당 컨트롤러의 정보를 로그로 출력하기 위한 준비 
	private static final Logger log = 
			LoggerFactory.getLogger(SampleController3.class);
	
	// /doD 주소를 사용해서 데이터 전달하는 처리 
	// name = 홍길동 파라미터 값을 itwillTest.jsp 페이지에서 출력 
	
	
	// doC1 주소를 통해서 itwill.jsp (view)페이지 이동 
	@RequestMapping("/doD")
	public String doD(@ModelAttribute("name")  String name) {
		
		log.info("doD() 메서드 호출 itwillTest.jsp 이동");
		log.info("전달받은 메시지 : " + name);
		return "itwillTest";
	}
	
	// view페이지로 객체를 전달
	// doMember 주소요청 -> itwillMember.jsp  생성해서 
	// 객체에 들어있는 회원정보를 출력 
	
	
	/*컨트롤러 -> view이동시 객체를 가지고 이동하기 위해선 
	 * Model객체가 필요함 
	 * 
	 * Model 객체에 값 저장 1) addAttribute(객체);    2) addAttribute("이름",객체);
	 * 
	 * 1) 번으로 저장해서 전달할 경우 뷰페이지에서 ${"객체의 클래스타입(첫글자 소문자)".속성} 호출
	 * 2) 번으로 저장해서 전달할경우 뷰페이지에서 ${"이름".속성} 호출
	 * 
	 * */
	
	
	@RequestMapping("/doMember")
	public String doMember(Model model) {
		// Model 클래스 -> 스프링에서 제공되는 뷰에 데이터를 전달하는 컨테이너
		
		log.info("doMember() 메서드 호출 itwillMember.jsp 이동");
		
		// 회원객체 생성 -> 정보저장 
		ITWILLBean user = new ITWILLBean("사람","010-2810-0000", 22);// set 메서드로 안하려고 생성자에 일부로 넣음
		log.info("itwill bean 객체 생성" + user);
		
		model.addAttribute(user);
		model.addAttribute("itwill", user);
		
		log.info("model 객체에 정보를 저장하고 페이지 이동");
		

		
		return "itwillMember" ;
	}
	
	
	
	
	
}
