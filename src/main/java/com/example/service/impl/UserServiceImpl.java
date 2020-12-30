package com.example.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.mapper.UserMapper;
import com.example.dao.models.User;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper; 

	@Override
	public boolean checkUser(User user) {
		User userinfo = userMapper.checkUser(user);
		if(userinfo == null) return false;
		else return true;
	}

	@Override
	public List<User> listall() {
		List<User> result = userMapper.selectAll();
		return result;
	}

	@Override
	public List<Map<String, Object>> getScoreByUserId(String userid) {
		List<Map<String, Object>> result = userMapper.getScoreByUserId(userid);
		return result;
	} 

}
