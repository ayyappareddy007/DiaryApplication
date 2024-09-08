package com.ayyappa.springmvcdemo1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ayyappa.springmvcdemo1.model.DiaryModel;
import com.ayyappa.springmvcdemo1.model.UserModel;
import com.ayyappa.springmvcdemo1.service.DiaryEntryService;

@Controller
public class DiaryController {
	
	@Autowired
	private DiaryEntryService diaryEntryService;
	
	@RequestMapping("add")
	public String addEntry(HttpSession session) {
		UserModel userModel = (UserModel)session.getAttribute("user");
		if(userModel != null) {
			return "addEntry";
		}
		return "redirect:/";
	}
	
	@RequestMapping("addEntry")
	public String addDiaryEntry(@RequestParam("date") String date, @RequestParam("description") String description, HttpSession session) {
		UserModel userModel = (UserModel)session.getAttribute("user");
		if(userModel != null) {
			DiaryModel diaryModel = new DiaryModel();
			diaryModel.setUser_id(userModel.getId());
			diaryModel.setDate(date);
			diaryModel.setDescription(description);
			diaryEntryService.addDiaryEntry(diaryModel);
			
			return "redirect:/home";
		}
		else {
			return "redirect:/";
		}
	}
	
	@RequestMapping("view")
	public ModelAndView view(@RequestParam("id") int id, ModelAndView mv, HttpSession session) {
		UserModel userModel = (UserModel)session.getAttribute("user");
		if(userModel != null) {
			mv.addObject("view", diaryEntryService.viewDiary(id));
			mv.setViewName("viewEntry");
			return mv;			
		}
		else {
			mv.setViewName("redirect:/");
			return mv;
		}
	}
	@RequestMapping("update")
	public ModelAndView update(@RequestParam("id") int id, ModelAndView mv, HttpSession session) {
		UserModel userModel = (UserModel)session.getAttribute("user");
		if(userModel != null) {
			mv.addObject("view", diaryEntryService.viewDiary(id));
			mv.setViewName("updateEntry");
			return mv;
			
		}
		else {
			mv.setViewName("redirect:/");
			return mv;
		}
	}
	@RequestMapping("updateEntry")
	public String update(@RequestParam("id")int id, @RequestParam("description") String desc, HttpSession session) {
		UserModel userModel = (UserModel)session.getAttribute("user");
		if(userModel != null) {
			DiaryModel diaryModel = new DiaryModel();
			diaryModel.setId(id);
			diaryModel.setDescription(desc);
			int n = diaryEntryService.updateDiaryEntry(diaryModel);
			if(n>0)
				return "redirect:/home";
			
			else
				return "updateEntry";			
		}
		else {
			return "redirect:/";
		}
			
		
	}
	@RequestMapping("delete")
	public String delete(@RequestParam("id")int id) {
		DiaryModel diaryModel = new DiaryModel();
		diaryModel.setId(id);
		int n = diaryEntryService.deleteDiary(diaryModel);
		return "redirect:/home";
	}
}
