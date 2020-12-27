package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.models.User;
import com.example.service.impl.UserServiceImpl;

@Controller
public class IndexController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/index")
	public ModelAndView index(String userid, String pwd,HttpServletRequest req) {
		ModelAndView model = new ModelAndView();
		User user = new User();
		HttpSession session = req.getSession();
		List<User> ulist = userServiceImpl.listall();
		model.addObject("userlist",ulist);
		User sesUser = (User) session.getAttribute("user");
		if(sesUser != null) {
			model.setViewName("userinfo");
			model.addObject("userinfo",sesUser);
			return model;
		}
		user.setUserid(userid);
		user.setPassword(pwd);
		model.setViewName("index");
		model.addObject("userinfo",user);
		if(userid == null || pwd == null) return model;
		boolean isexist = userServiceImpl.checkUser(user);
		if(isexist) {
			model.setViewName("userinfo");
			session.setAttribute("user", user);
		}
		else {
			user.setUserid("账号密码错误");
			model.setViewName("index");
		}
		
		model.addObject("userinfo",user);
		return model;
	}
	
	@RequestMapping("/quit")
	public String quit(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "index";
	}
	
	@RequestMapping("/getuser")
	@ResponseBody
	public Map<String,Object> getuser(String userid) {
		Map<String, Object> result = null;
		if(userid == null || userid.equals("")) {
			result = new HashMap<String, Object>();
			result.put("msg", "参数不合法！");
			return result;
		} else {
			result = new HashMap<String, Object>();
			result.put("msg", "111111");
			return result;
		}
		

	}
}
