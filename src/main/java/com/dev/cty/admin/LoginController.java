package com.dev.cty.admin;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dev.cty.dto.ReportDto;
import com.dev.cty.entity.Report;
import com.dev.cty.service.IReportService;
import com.sun.org.apache.regexp.internal.recompile;

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

	
}