package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

// @Repository : 해당클래스를 DAO로 사용하겠다 스프링에 등록

@Repository
public class MemberDAOImpl implements MemberDAO{

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

	
}
