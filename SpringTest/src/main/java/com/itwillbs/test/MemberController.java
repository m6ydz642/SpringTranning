package com.itwillbs.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;


@Controller
@RequestMapping(value = "/member/*") // 클래스 위에서도 사용 가능

public class MemberController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	// 서비스 계층 필요함 -> 의존 주입
	@Inject
	private MemberService service;
	
	
	
	
	// 동작 구현
	// http://localhost:6060/test/testCon
	
	// http://localhost:6060/test/member/testCon // 위에서 접근 방식 바꿈
	@RequestMapping("/testCon")
	public void TestController() {
		logger.info("컨트롤러 테스트 중");
		logger.info("Controller : /testCon주소일때 처리 (테스트용 회원가입) ");
		
		// 회원 정보 생성 (나중에는 view 페이지에서 전달 받음)
		MemberVO vo = new MemberVO();
		vo.setUserid("12345"); //db안에 있는 아이디임
		vo.setUserpw("12345");  //db안에 있는 비밀번호임
		vo.setUsername("그냥데이터 넣음"); // 유저네임
		
		
		
		// 서비스 계층에 있는 동작중에서 회원가입 처리 호출
		// 결과 확인
		
		service.insertMember(vo);
		logger.info("멤버 컨트롤러 " + vo);
	}
	
	// 회원 가입 정보를 입력 처리(GET) - 화면
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertGET() throws Exception{
		logger.info("회원가입 정보 입력창 (view) 호출");
		logger.info("/member/insert (get) -> views/member/insertForm.jsp 이동");
		
		
		return "/member/insertForm";
	}
	// 회원 가입 처리 동작 (POST)
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	
	public void insertPost(MemberVO vo) throws Exception {

		
		// 메서드 전달 인자를 사용해서 페이지 이동시 정보를 가져올 수 있음
		// 입력 받는 페이지 (view-jsp)에서 전달 되는 데이터의 이름을 
		// vo 객체의 변수명(컬럼명) 으로 통일시켜서 이동시킨다.
		//  
		
		logger.info("회원가입 정보 입력창 (post) 호출");
		logger.info("컨트롤러에서 /insert주소에 post방식");
		logger.info(vo + "<--멤버 vo");
		
		// 회원가입 처리 메서드 호출 (서비스 계층)
		
		service.insertMember(vo); // insert 
		logger.info("회원가입 완료!");
		
		
		
	}
	
	

}
