package com.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.UserDaoImpl;
import com.vo.Result;
import com.vo.User;
import com.vo.UserInfo;

/**
 * 服务实现。
 * 
 * @author tangke
 *
 */
@WebService
public class TestWsImpl implements TestWs {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestWsImpl.class);
	@Autowired
	private UserDaoImpl userDaoImpl;


	@Override
	@WebMethod
	public Result testAddUserInfo(UserInfo userInfo) throws Exception {
		LOGGER.info("开始执行testAddUserInfo()");
		Result result = new Result();
		if (this.userDaoImpl.addUserInfo(userInfo)) {
			result.setFlag(true);
			result.setDescribe("userInfo添加成功！");
		} else {
			result.setFlag(false);
			result.setDescribe("userInfo添加失败！");
		}
		return result;
	}

	@Override
	@WebMethod
	public Result testGetUserInfo(UserInfo userInfo) {
		LOGGER.info("开始执行testGetUserInfo()");
		Result result = new Result();
		UserInfo resultUserInfo = this.userDaoImpl.getUserInfo(userInfo);
		if(null == resultUserInfo) {
			result.setFlag(false);
			result.setDescribe("userInfo查询失败！");
		}else{
			result.setFlag(true);
			result.setDescribe("userInfo查询成功！");
			result.setUserInfo(resultUserInfo);
		}
		return result;
	}

	@Override
	public Result testAddUser(User user) {
		Result result = new Result();
		if (this.userDaoImpl.addUser(user)) {
			result.setFlag(true);
			result.setDescribe("user添加成功！");
		} else {
			result.setFlag(false);
			result.setDescribe("user添加失败！");
		}
		return result;
		
	}

	@Override
	public Result testGetUser(User user) {
		
		Result result = new Result();
		User resultUser = this.userDaoImpl.getUser(user);
		
		if(null == resultUser) {
			result.setFlag(false);
			result.setDescribe("user查询失败！");
		}else{
			UserInfo userInfo = new UserInfo();
			userInfo.setUser(resultUser);
			result.setFlag(true);
			result.setDescribe("user查询成功！");
			result.setUserInfo(userInfo);
		}
		return result;
	}

}
