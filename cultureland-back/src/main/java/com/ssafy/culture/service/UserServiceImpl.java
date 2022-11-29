package com.ssafy.culture.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.culture.dao.UserDao;
import com.ssafy.culture.dto.User;

@Service
public class UserServiceImpl implements UserService{
	
	private UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public int addUser(User user) throws SQLException {
		return userDao.insertUser(user);
	}

	@Override
	public User login(User user) throws SQLException {
		return userDao.selectUser(user);
	}

	@Override
	public User getUser(long userId) throws SQLException {
		return userDao.userInfo(userId);
	}

	@Override
	public int removeUser(long userId) throws SQLException {
		return userDao.deleteUser(userId);
	}

	@Override
	public String findPassword(Map<String,String> username) throws SQLException {
		return userDao.selectPassword(username);
	}

	@Override
	public int modifyUser(User user) throws SQLException {
		return userDao.updateUser(user);
	}

	@Override
	public void saveRefreshToken(long userId, String refreshToken) throws SQLException {
		Map<String, String> map = new HashMap<>();
		map.put("userId", Long.toString(userId));
		map.put("token", refreshToken);
		userDao.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(long userId) {
		return null;
	}

	@Override
	public void deleRefreshToken(String userId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", null);
		
	}

	@Override
	public User getByUserName(String username) throws SQLException {
		return userDao.selectUserName(username);
	}

}
