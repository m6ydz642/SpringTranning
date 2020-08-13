package com.itwillbs.persistence;

import java.util.HashMap;
import java.util.Map;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.test.HomeController;


// @Repository : 해당클래스를 DAO로 사용하겠다 스프링에 등록

@Repository
public class MemberDAOImpl implements MemberDAO{

	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	// DAO처리 
	
	// 디비연결 
	@Inject
	private SqlSession sqlSession;
	// -> 디비연결, 자원해제, 쿼리실행 
	
	// mapper주소 
	private static final String namespace = "com.itwillbs.mapper.MemberMapper";
	
	
	
	
	@Override
	public String getTime() {
		// sqlSession 객체를 사용해서 select 구문을 호출
		// memberMapper.xml파일에 구문을 호출 (namespace + ".id값")
		System.out.println("MemberDAOImpl_getTime() 호출! ");
		System.out.println("sqlSession 객체를 주입받는다! ");
		System.out.println("SQL구문 실행하기 위해서 mapper로 이동 ");
		
		return sqlSession.selectOne(namespace +".getTime");
	}




	@Override
	public void insertMember(MemberVO vo) {
		// 회원 가입 처리 - MemberMapper.xml파일과 연결 처리
		
		System.out.println("dao impl : 회원가입 메서드 호출(회원정보가져옴) : " + vo);
		System.out.println("membermapper.xml 호출");
		sqlSession.insert(namespace + ".insertMember", vo);
		System.out.println("DAO Impl : 회원 저장 완료! Test파일로 이동");
		
		
	}
	
	@Override
	public MemberVO getMember(String id) {
		System.out.println("@@@@ TEST파일에서 메서드 호출 @@@@");
		System.out.println("@@@@ MyBatis 사용 memberMapper로 이동@@@@");
		
		// com.itwillbs.mapper.MemberMapper.getMember 
		MemberVO vo = sqlSession.selectOne(namespace + ".getMember", id); // xml에 쿼리 이미 써놔서 또 쿼리문 안써도 됨
									// <select id="getMember"> 부분에서 id 가져옴
		System.out.println("@@@@ Mapper에서 SQL 구문 실행");
		System.out.println("@@@@ 결과를 저장해서 TEST페이지로 이동");
		System.out.println("vo 반환" + vo);
		return vo;
	}




	@Override
	public MemberVO getMemberWithIdPw(String id, String pw) {
		// 회원 정보(ID/PW)에 해당하는 회원정보 가져오기 메서드
		logger.info("@@@@ 회원 ID/PW호출?");
		logger.info("@@@@ DAO : TEST에서 메서드 호출");
		logger.info("@@@@ DB연결 준비 (의존 주입-sqlSession)");
		logger.info("MyBatis 사용 Mapper이동해서 SQL" );
		logger.info("파라미터값 2개 전달하기 위해서 Map객체 생성");
		
		
		 // 키는 스트링 값은 오브젝트
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// new HashMap<String,Object>
		// 저장할 때 키 값을 테이블의 컬럼명으로 저장
		// -> Mapper에서 바로 전달 
		paramMap.put("userid",id);
		paramMap.put("userpw",pw);
		
		MemberVO vo = sqlSession.selectOne(namespace + ".getMemberIdPw", paramMap);
		logger.info("SQL구문 실행 완료");
		logger.info("결과 저장해서 다시 테스트 페이지로 이동");
		logger.info("memberDAOImpl -> vo 내용" + vo);
		
		
		return vo;
	}

	
}
