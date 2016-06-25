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
import com.dev.cty.service.ILoginService;
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

	@Autowired
	ILoginService ils;
	@RequestMapping("index.do")
	protected ModelAndView toIndex(HttpServletRequest request,HttpServletResponse response){
		List<Report> reports = ils.getReports();
		request.setAttribute("reports", reports);
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
	@RequestMapping("showReports.do")
	protected ModelAndView toshowReports(HttpServletRequest request,HttpServletResponse response){
		List<Report> reports = ils.getReports();
		System.out.println(reports);
		request.setAttribute("reports", reports);
		ModelAndView model = new ModelAndView("showReports");
		return model;
	}
	@RequestMapping("addReportPage.do")
	protected ModelAndView toAddReportPage(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView("addReportPage");
		return model;
	}
	
	
	@RequestMapping("addReport.do")
	protected ModelAndView toAddReport(ReportDto repDto,HttpServletRequest request){

		int a = ils.addReport(repDto);
		ModelAndView model = null;
		if (a==1) {
			model = new ModelAndView("success");
		}else{
			model = new ModelAndView("fail");
		}
		return model;
	}
	@RequestMapping("editPage")
	protected ModelAndView toEditPage(HttpServletRequest request){
		String repName = request.getParameter("repName");
		Report rep = ils.getReport(repName);
		request.setAttribute("rep",rep );
		ModelAndView model = new ModelAndView("editPage");
		return model;
	}
	@RequestMapping("editReport")
	protected ModelAndView toEditReport(ReportDto repDto,HttpServletRequest request){
		int a = ils.editReport(repDto);
		
		ModelAndView model = null;
		if (a==1) {
			model = new ModelAndView("success");
		}else{
			model = new ModelAndView("fail");
		}
		return model;
	}
	
	@RequestMapping("deleteReport")
	protected ModelAndView toDeleteReport(HttpServletRequest request){
		String repName = request.getParameter("repName");
		int a = ils.deleteReport(repName);
		
		ModelAndView model = null;
		if (a==1) {
			model = new ModelAndView("success");
		}else{
			model = new ModelAndView("fail");
		}
		return model;
	}
	
}