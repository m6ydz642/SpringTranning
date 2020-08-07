package com.itwillbs.domain;

public class ITWILLBean {
	// vo (value object) : 객체를 사용해서 데이터를 저장하고 이동시키기 위한 객체
	
	
	private String name;
	private String tel;
	private int age;
	
	public ITWILLBean() {
		
	}
	
	public ITWILLBean(String name, String tel, int age) {	// set 메서드로 안하려고 인자 들어간 생성자 일부로 만듦
		super();
		this.name = name;
		this.tel = tel;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
