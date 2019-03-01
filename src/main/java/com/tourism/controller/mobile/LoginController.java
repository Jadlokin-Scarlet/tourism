package com.tourism.controller.mobile;

import com.tourism.entity.User;
import com.tourism.mapper.UserMapper;
import com.tourism.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/mobile")
public class LoginController {

	private UserService userService;

	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("login")
	public String login(User userSelective, ModelMap modelMap, HttpSession session){
		User user = userService.login(userSelective);
		if(user == null){
			modelMap.addAttribute("message","用户名或密码错误");
		}
		session.setAttribute("user",user);
		return "index";
	}

	@RequestMapping("register")
	public String register(User user,ModelMap modelMap){
		return null;
	}
}
