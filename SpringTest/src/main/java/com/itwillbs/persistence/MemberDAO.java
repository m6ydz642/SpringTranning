package com.itwillbs.persistence;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	
	// DB를 사용해서 현재 시간정보 출력 
	public String getTime();

	// 회원가입 처리 메서드
	public void insertMember(MemberVO vo);
}
