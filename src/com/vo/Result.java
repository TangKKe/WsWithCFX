package com.vo;

import java.io.Serializable;

/**
 * 报文体返回封装类
 * @author tangke
 *
 */
public class Result implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}


	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	

	public String getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(String loginInfo) {
		this.loginInfo = loginInfo;
	}


	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}


	private Boolean flag;
	
	private String describe;
	
	private UserInfo userInfo;
	
	private String loginInfo;

}
