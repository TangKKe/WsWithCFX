package com.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.vo.Result;
import com.vo.User;
import com.vo.UserInfo;


/**
 * 服务接口。
 * @author tangke
 *
 */
@WebService
public interface TestWs {
	/**
	 * 测试增加用户。
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	public Result testAddUserInfo(UserInfo userInfo) throws Exception;
	/**
	 * 测试查询用户。
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	public Result testGetUserInfo(UserInfo userInfo) throws Exception;
	
	/**
	 * 测试添加用户名和密码。
	 * @param user
	 * @return
	 */
	@WebMethod
	public Result testAddUser(User user);
	
	/**
	 * 测试查询用户名和密码。
	 * @param user
	 * @return
	 */
	@WebMethod
	public Result testGetUser(User user);
		

}
