package com.itwillbs.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {

	private static final Logger log = 
			LoggerFactory.getLogger(SampleController4.class);
	
	// 페이지 이동 
	// 리다이렉트 이동
	
	// http://localhost:8080/test/doE
	@RequestMapping("/doE")
	public String doE(@ModelAttribute("value")  String value) {
		log.info("doE() 메서드 호출 이동");
		
		// return "/doA"; // 얘는 비추천 (껍데기만 감) 
		/**********************************************************/
		return "redirect:/doF"; // 이렇게 하면 1번컨트롤러 4번컨트롤러 같이 요청됨
		// return "forward:/doA";  // 컨트롤러를 거치고 보여줌
		// 둘중에 하나만 쓰는걸로
		/**********************************************************/
	}
	
	
	
	// doF 주소를 처리하는 메서드 doF()
	// doE페이지를 호출시 파라미터 값 abc=1234 가지고 이동해오는 페이지
	
	// 주소 /doE?abc=1234 -> 리다이렉트 /doF(abc값 출력)
	
	// http://localhost:6060/test/doF?value=%ED%9D%A0
	// http://localhost:6060/test/doE?value=hangleerror
	@RequestMapping("/doF")
	public void doF(@ModelAttribute("value")  String value) {
		
		// 전달받을때도 modelattribute저거 써야 됨
		
		log.info("doF() 메서드 호출 이동");
		log.info("value " + value);
		// return "redirect:/doF"; 

	}
	
	
	// http://localhost:6060/test/doM
	// 이번에는 @ModelAttribute가 아닌 방식으로 사용
	
	@RequestMapping("/doM")
	public String doM(RedirectAttributes rttr) {
		// RedirectAttributes 차이점 -> 주소줄에 URI에 보이지 않게 데이터 전달
		
		
		log.info("doM() 메서드 호출 이동");
		
	//	rttr.addAttribute("value", "123123213123123"); // 이 방식도 가능, 근데 이것도 한글 깨짐 
		rttr.addFlashAttribute("value","벨류다"); // 쓰면 주소에 값 사라짐, 한글도 되네? 
												 // 새고고침 하면 사라짐
												// 휘발성을 띔, 한번쓰고 사라짐
		// 조회수 연속으로 조회하는거 막는 용도로 사용 (게시판에서 많이씀)
		
		
		// 페이지 이동 (리다이렉트:주소도 변경, 페이지도 변경) + 데이터 가지고 이동
		/*
		 * 1) doE -> doF
		 * 주소요청 : .../doE?value=1234
		 * 
		 * 컨트롤러 : doE (@ModelAttribute("value")  String value)
		 * redirect:/doF -> ../doF?value=1234
		 * 
		 * 컨트롤러 : doF (@ModelAttribute("value")  String value)
		 * view페이지에서 출력
		 * 
		 * 
		 * 2) doE -> doF 
		 * ../doE
		 * doE(RedirectAttributes rttr)
		 * rttr.addAttribute(); 
		 * 
		 * doF (@ModelAttribute("value")  String value)
		 * redirect:/doF	->	../doF?value=1234
		 * view 페이지에서 출력
		 * 
		 * 
		 * 3) doE -> doF 
		 * 주소 요청 : ../doE
		 * 컨트롤러 : doE(RedirectAttributes rttr)
		 * rttr.addAttribute(); 
		 * 
		 * 컨트롤러 : doF (@ModelAttribute("value")  String value)
		 * redirect:/doF	->	../doF?value=1234
		 * view 페이지에서 출력
		 * F5 새로고침 했을땐 데이터가 사라진다 (1회성 속성값)
		 */
		
		/*
		
		컨트롤러에서 처리하는 메서드 전달인자로 RedirectAttributes사용시
		1) addAttribute(이름, 값) - 주소(URI)표시 O, F5 O(값이 유지)
		2) addFlashAttribute(이름, 값) - 주소 (URI) 표시 X  (1회성 값)
				
		*/
		
		return "redirect:/doF";

	}
	
	
}
