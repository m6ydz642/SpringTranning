package com.itwillbs.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class MysqlConnectionTest {

	// DB연결정보
	// 드라이버,URL,ID,PW

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/springdb?useSSL=false";
	// 8.0 버전
	// private static final String
	// DBURL="jdbc:mysql://localhost:3306/springdb?useSSL=false&serverTimezone=Asia/Seoul";
	private static final String DBID = "root";
	private static final String DBPW = "1234";

	// Junit => 프레임워크 테스트 도구
	// 테스트 동작을 메서드로 구현후 실행

	// 디비연결 테스트
	@Test
	public void testConnection(){
		// 드라이버 로드
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try (Connection con = DriverManager.getConnection(DBURL, DBID, DBPW)) {
			// 괄호 자체가 try with 구문임
			// 자원해제 자동으로


			System.out.println("디비 연결 객체 : " + con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * // ->try-with구문 사용
		 * finally 블럭 없이 자동으로 자원 해제 처리 가능하도록
		 * JDK7~이상 사용 가능
		 * try(AutoCloseableable 객체) {
		 * 
		 * }catch (Exception e) {
		 * 
		 * }
		 *
		 */
		
		
		
		
	}

}
