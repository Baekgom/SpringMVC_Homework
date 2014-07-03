package com.baekgom.vo;

public class UserVO extends VO {

	private String name;
	private String email;

	public UserVO(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + super.getId() + " name=" + name + ", email="
				+ email + "]";
	}

}
