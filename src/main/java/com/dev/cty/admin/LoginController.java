package com.dev.cty.admin;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController{
	
	@RequestMapping("login.do")
	protected ModelAndView toLogin(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String userName = request.getParameter("userName");
		if ("admin".equals(userName)) {
			response.getWriter().print("true");
		}else {
			response.getWriter().print("false");
		}
		ModelAndView model = new ModelAndView("login");
		
		return model;
	}
	
	@RequestMapping("logins.do")
	public void toLogins(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println(userName);
		if ("admin".equals(userName)&&"admin".equals(password)) {
			request.getSession().setAttribute("userName", userName);
			response.getWriter().print("true");
		}else {
			response.getWriter().print("false");
		}
		
	}
	@RequestMapping("header.do")
	protected ModelAndView toHeader(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView model = new ModelAndView("header");
		return model;
	}
	@RequestMapping("left.do")
	protected ModelAndView toLeft(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView model = new ModelAndView("left");
		return model;
	}
	@RequestMapping("index.do")
	protected ModelAndView toIndex(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		List list = new ArrayList<>();
		list.add("111111111111");
		list.add("2222222222222222");
		list.add("333333333333333333333");
		list.add("44444444444444444");
		list.add("5555555555555555");
		list.add("6666666666666666");
		request.setAttribute("list", list);
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
}