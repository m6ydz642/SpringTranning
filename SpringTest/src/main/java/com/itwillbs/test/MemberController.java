package com.itwillbs.test;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	public String  insertPost(MemberVO vo) throws Exception { // 가입후 리다이렉트

		
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
		
		// 페이지 이동 (로그인 페이지-> 컨트롤러 -> 뷰)
		// WEB-INF/views/member/login.jsp
		return "redirect:/member/login";
		
	}
	
	// 로그인 처리 (GET) 메서드 
	// http://localhost:6060/test/member/login
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginGET() throws Exception{
		logger.info("loginGET() 실행");
		logger.info("view 페이지로 연결(member/login.jsp");
		logger.info("member/login get -> /member/login.jsp이동");
		return "/member/login";
		
	}
	
	// http://localhost:6060/test/member/login
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginPOST(MemberVO vo, HttpSession session) throws Exception{
		logger.info("loginPOST() 실행");
		logger.info("view 페이지로 연결(member/main.jsp");
		logger.info("member/login get -> /member/main.jsp이동");
		// 1) 아이디, 비밀번호 저장
		// 2) 로그인 여부 판별
		
		// 3) 로그인시 - 아이디값 (세션) -> main.jsp이동
		// 로그인 실패 - /test/member/login 이동
		MemberVO DBvo = service.loginCheck(vo);
		
		logger.info("전달정보 : " + DBvo);
		
		
		// 로그인 실패
		if(DBvo == null) {
			return "redirect:/test/member/login";
		}
		
		// 로그인 성공
		// 세션객체 사용(login.jsp(get) 페이지에서 post방식으로 올때 내장객체를 가지고 온다.
		session.setAttribute("userid", DBvo.getUserid());
		
		return "redirect:/member/main";
		
	}
	
	// 메인페이지 (/member/main(get))
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public String mainGET() throws Exception {
		logger.info("메인페이지 도착");
		logger.info("/member/main (get) -> /member/main.jsp");
		return "/member/main";
	}
	
	// 로그아웃 (/member/logout)
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String LogoutGET(HttpSession session) throws Exception {
		logger.info("로그아웃 페이지");
		logger.info("/member/logout get -> /member/main 이동");
		
		// 세션값을 초기화 
		session.invalidate(); // 초기화
		
		// main 페이지로 이동

		return "redirect:/member/main";
	}
	
	// 회원정보 보기 /member/info
	@RequestMapping(value="/info", method = RequestMethod.GET)
	public String infoGET(HttpSession session, Model model) throws Exception {
		
		logger.info("/member/info get-> /member/info.jsp이동");
		
		// 가져온 회원정보를 저장해서 해당 jsp페이지로 이동
		// (/member/info.jsp)
		
		// 세션값 (id)가져오기
		String id = (String)session.getAttribute("userid");
		
		// 회원정보 가져오기 (service -> DAO -> mysql)
		MemberVO vo = service.getMember(id);
		logger.info("찾아온 회원 정보 : " + vo);

		// String id = (String)session.getAttribute("userid");
		// mdodel2 객체 사용 (컨트롤러 -> 뷰 이동시 정보저장 공간)
		model.addAttribute("memberVO", vo);
		
		// service.getMember(id);
		
		return "/member/info";
	}
	
	
// 회원정보 수정
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String UpdateGET(HttpSession session, Model model) throws Exception {
		
		logger.info("updateGET() 호출");
		logger.info("/member/update get-> /member/update.jsp 이동");
		
		// 세션 ID값 처리
		String id = (String) session.getAttribute("userid");
		// 서비스 -> DAO -> DB
		// 회원정보 모두를 가져오는 동작
		MemberVO vo = service.getMember(id);
		
		// 회원 정보를 Model 객체에 담아서 view페이지로 전달
		model.addAttribute("memberVO",vo);
		
		// 페이지이동 (void)
		// /member/update.jsp 페이지 이동
		
		

		return "/member/update";
	}

	
	
	
}
