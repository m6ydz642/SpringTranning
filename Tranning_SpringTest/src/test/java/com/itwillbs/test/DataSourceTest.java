package com.itwillbs.test;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.jdbc.Connection;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
) -> 일반 클래스를 테스트 할때 스프링으로 테스트 할 수 있도록 세팅

*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
)

public class DataSourceTest {

	// 스프링 테스트를 사용해서 디비연결 확인
	
	// root-context.xml 있는 bean객체를 가져와서 주입
	
	// 디비 연결정보를 가져오기
	
	@Inject
	private DataSource ds;
	
	@Test
	public void testCon() throws Exception{
		try(Connection con = (Connection) ds.getConnection()) {
			System.out.println("스프링 의존주입을 사용한 디비 연결");
			System.out.println(con);
		}catch (Exception e) {

		}
	}

}
