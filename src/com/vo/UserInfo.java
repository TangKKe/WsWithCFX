package com.vo;

import java.io.Serializable;

/**
 * 用户信息。
 * @author tangke
 *
 */
public class UserInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String[] getEmailArray() {
		return emailArray;
	}

	public void setEmailArray(String[] emailArray) {
		this.emailArray = emailArray;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String id;
	
	private String addr;
	
	private String[] emailArray;
	
	private String tel;
	
	private User user;

}
