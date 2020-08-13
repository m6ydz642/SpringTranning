package com.itwillbs.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

// @Service : 스프링이 해당 파일을 MemberService객체로 인식하게 처리


@Service
public class MemberServiceImpl implements MemberService{
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	// DB에 접근이 가능해야 함
	// MemberDAO 객체 생성 -> 객체 의존 주입
	@Inject
	private MemberDAO mdao;
	
	
	
	
	
	
	@Override
	public void insertMember(MemberVO vo) {
	System.out.println("@@@@ Service : DAO연결을 위해서 객체 주입");
	System.out.println("@@@@ Service : 회원 가입을 하기 위해서 DAO처리 메서드 호출");
	
		
	mdao.insertMember(vo);
	
	System.out.println();
	logger.info("멤버 서비스vo실행 완료");
	
	}
	
	

}
