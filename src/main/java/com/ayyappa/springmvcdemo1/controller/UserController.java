package com.ayyappa.springmvcdemo1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ayyappa.springmvcdemo1.model.UserModel;
import com.ayyappa.springmvcdemo1.service.DiaryEntryService;
import com.ayyappa.springmvcdemo1.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private DiaryEntryService diaryEntryService;
	
	@RequestMapping("/")
	public String index() {
		return "login";
	}
	
	@RequestMapping("login")
	public String login(@RequestParam("name") String name, @RequestParam("password") String password, ModelAndView mv, HttpSession session) {
		
		UserModel user = new UserModel();
		user.setUserName(name);
		user.setPassword(password);

		UserModel um = userService.loginService(user);
		if(um != null) {
			session.setAttribute("user", um);
			return "redirect:/home";
		}else {
			return "login";
		}
	}
	
	@RequestMapping("register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("registration")
	public ModelAndView registerUser(@RequestParam("name") String name, @RequestParam("password") String password, ModelAndView mv) {
		
		UserModel user = new UserModel();
		user.setUserName(name);
		user.setPassword(password);
		int n = userService.registerService(user);
		if(n>0) {
			mv.setViewName("login");
		}
		else {
			mv.setViewName("register");
		}
		return mv;
	}
	@RequestMapping("home")
	public ModelAndView home(ModelAndView mv, HttpSession session) {
		UserModel userModel = (UserModel) session.getAttribute("user");
		if(userModel != null) {
			mv.addObject("user", userModel);
			mv.addObject("diary-list", diaryEntryService.getDiaries(userModel.getId()));
			mv.setViewName("home");			
		}else {
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	@RequestMapping("sign-out")
	public String logout(HttpSession session) {
		if(session != null)
			session.invalidate();
		return "redirect:/";
	}
}
