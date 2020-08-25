package com.itwillbs.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwillbs.domain.ITWILLBean;

public class SampleController5 {

	private static final Logger log = 
			LoggerFactory.getLogger(SampleController5.class);
	
	// json데이터 처리가 쉬움
	// http://localhost:6060/test/doJson
	
	@RequestMapping("/doJson")
	public @ResponseBody ITWILLBean doJson() {
		
		// ResponseBody -> json으로 알아서 바꿔줌 ㅋㅋㅋ 
		// ResponseBody : 일반객체를 Json타입으로 변경해서 리턴
		// 상용 브라우저들은 Json파서를 포함하고 있음 -> 알아서 페이지에서 보여줌 
		
		
		
		log.info("/doJson페이지 요청, doJson호출");
		
		// Json객체를 만들 데이터 생성
		ITWILLBean member = new ITWILLBean("홍길동", "010-1234-1234",  11);
		
		return member; // 객체를 리턴
	}
	
}
