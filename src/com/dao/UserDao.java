package com.dao;

import com.vo.User;
import com.vo.UserInfo;

/**
 * 持久层接口。
 * @author tangke
 *
 */
public interface UserDao {
	/**
	 * 添加用户基本信息。
	 * @param userInfo
	 * @throws Exception 
	 */
	public boolean addUserInfo(UserInfo userInfo) throws Exception;
	/**
	 * 获取用户基本信息。
	 * @param userInfo
	 * @return
	 */
	public UserInfo getUserInfo(UserInfo userInfo) throws Exception;
	
	/**
	 * 添加用户信息。
	 * @param user
	 */
	public boolean addUser(User user);
	/**
	 * 获取用户名及密码。
	 * @param user
	 * @return
	 */
	public User getUser(User user);

}
