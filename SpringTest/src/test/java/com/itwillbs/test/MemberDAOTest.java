package com.itwillbs.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

// 스프링 테스트로 사용할 수 있도록 설정
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class MemberDAOTest {
	// 컨트롤러/뷰에서 호출 역할
	
	
	// 디비처리 객체 - 의존 주입 (DI)
	@Inject
	private MemberDAO mdao;
	// 테스트 동작 
	
	// DB시간정보 호출 메서드 
	// @Test : 있어야지만 반드시 Junut을 실행 가능 
	@Test
	public void testTime() throws Exception{
		System.out.println("DI를 사용해서 MemberDAO생성 완료");
		
		System.out.println("DAO동작 호출");
		String value = mdao.getTime();
		System.out.println("결과 : " + value);
		
		System.out.println("DAO 처리 완료");
	}
	
	
	// 회원 가입 처리하는 동작 (테스트)
	@Test // 있어야 junit 가능
	public void testInsertMember() throws Exception{
		// MemberDAO회원가입 메서드 호출
		
		// 회원 객체 생성
		MemberVO kim = new MemberVO();
		kim.setUserid("wow");
		kim.setUserpw("1234");
		kim.setUsername("관리자");
		kim.setEmail("admin@itwill.co.kr");
		
		System.out.println("회원 객체 생성 완료");
		System.out.println("dao객체 사용해서 회원가입 메서드 호출");
		mdao.insertMember(kim);
		
	}
	
	
	
}
