package com.example.service;

import java.util.List;
import java.util.Map;

import com.example.dao.models.User;

public interface UserService {

	public boolean checkUser(User user);
	
	public List<User> listall();
	
	public List<Map<String, Object>> getScoreByUserId(String userid);
}
