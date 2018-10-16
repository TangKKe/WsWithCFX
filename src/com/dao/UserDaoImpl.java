package com.dao;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Repository;
import org.springframework.data.redis.connection.RedisConnection;

import com.util.SerializeUtil;
import com.vo.User;
import com.vo.UserInfo;

/**
 * 持久层实现。
 * @author tangke
 *
 */
@Repository
public class UserDaoImpl implements UserDao {
	
	private static final Logger LOGGER =LoggerFactory.getLogger(UserDaoImpl.class);

	/**
	 * 注入redisTemplate模板。
	 */
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Autowired
	private RedisTemplate<Object,Object> redisTemplate1;

	@Override
	public boolean addUserInfo(UserInfo userInfo) throws Exception {
		LOGGER.info("开始执行userDaoImpl.addUserInfo");
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) {

				try {
					connection.set(SerializeUtil.serialize(userInfo.getId()), SerializeUtil.serialize(userInfo));
				} catch (SerializationException | IOException | DataAccessException e) {
					e.printStackTrace();
					try {
						throw e;
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					return Boolean.valueOf(false);
				}
				return Boolean.valueOf(true);

			}
		});

	}

	@Override
	public UserInfo getUserInfo(UserInfo userInfo) {
		LOGGER.info("开始执行userDaoImpl.getUserInfo");
		return redisTemplate.execute(new RedisCallback<UserInfo>() {
			public UserInfo doInRedis(RedisConnection connection) {
				try {
					byte[] key = SerializeUtil.serialize(userInfo.getId());
					if (connection.exists(key)) {
						byte[] value = connection.get(key);
						UserInfo userInfo = (UserInfo) SerializeUtil.unserialize(value);
						return userInfo;
					}
				} catch (IOException | DataAccessException e) {
					e.printStackTrace();
				}
				return null;
			}

		});
	}

	@Override
	public boolean addUser(User user) {
		try {
			redisTemplate1.opsForValue().set(user.getUserName(), user);
			return Boolean.valueOf(true);
		} catch (Exception e) {
			return Boolean.valueOf(false);
		}
	}

	@Override
	public User getUser(User user) {
		try {
			User user2 = (User) redisTemplate1.opsForValue().get(user.getUserName());
			return user2;
		} catch (Exception e) {
			return null;
		}
	}

}
