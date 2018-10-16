package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vo.User;
import com.vo.UserInfo;
import com.ws.TestWs;

/**
 * 客户端测试。
 * @author tangke
 *
 */
public class TestClient {
	private static TestWs testWs;
	
	static {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/beans-client.xml");
	    testWs = (TestWs) context.getBean("TestWsClient");
	}
	
	public static void main(String[] args) throws Exception {
		
//		testAddUserInfo();
//		testGetUserInfo();
//		testAddUser();
		testGetUser();
	}
	
	
	public static void testAddUserInfo() throws Exception {
		UserInfo userInfo = new UserInfo();
		User user = new User();
		user.setUserName("spdb1");
		user.setPassWord("spdb1");
		userInfo.setUser(user);
		userInfo.setAddr("上海浦东1");
		String[] emailArray = {"11111@qq.com","11111@163.com"};
		userInfo.setEmailArray(emailArray);
		userInfo.setTel("11111");
		userInfo.setId("1");
		testWs.testAddUserInfo(userInfo);
		
		
	}
	
	public static void testGetUserInfo() throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setId("1");
		testWs.testGetUserInfo(userInfo);
	}
	
	public static void testAddUser() {
		User user = new User();
		user.setUserName("邓奕波");
		user.setPassWord("123456");
		testWs.testAddUser(user);
	}
	
	public static void testGetUser() {
		User user = new User();
		user.setUserName("邓奕波");
		testWs.testGetUser(user);
		
		
	}

}
