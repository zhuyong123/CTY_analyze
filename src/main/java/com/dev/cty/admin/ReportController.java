package com.dev.cty.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dev.cty.dto.ReportDto;
import com.dev.cty.entity.Report;
import com.dev.cty.service.IReportService;

@Controller
public class ReportController {
	@Autowired
	IReportService irs;
	@RequestMapping("index.do")
	protected ModelAndView toIndex(HttpServletRequest request,HttpServletResponse response){
		List<Report> reports = irs.getReports();
		request.setAttribute("reports", reports);
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	@RequestMapping("showReports.do")
	protected ModelAndView toshowReports(HttpServletRequest request,HttpServletResponse response){
		List<Report> reports = irs.getReports();
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

		int a = irs.addReport(repDto);
		ModelAndView model = null;
		if (a==1) {
			model = new ModelAndView("redirect:/showReports.do");
		}else{
			model = new ModelAndView("fail");
		}
		return model;
	}
	@RequestMapping("editPage")
	protected ModelAndView toEditPage(HttpServletRequest request){
		String repName = request.getParameter("repName");
		Report rep = irs.getReport(repName);
		request.setAttribute("rep",rep );
		ModelAndView model = new ModelAndView("editPage");
		return model;
	}
	@RequestMapping("editReport")
	protected ModelAndView toEditReport(ReportDto repDto,HttpServletRequest request){
		int a = irs.editReport(repDto);
		
		ModelAndView model = null;
		if (a==1) {
			model = new ModelAndView("redirect:/showReports.do");
		}else{
			model = new ModelAndView("fail");
		}
		return model;
	}
	
	@RequestMapping("deleteReport")
	protected ModelAndView toDeleteReport(HttpServletRequest request){
		String repName = request.getParameter("repName");
		int a = irs.deleteReport(repName);
		
		ModelAndView model = null;
		if (a==1) {
			model = new ModelAndView("redirect:/showReports.do");
		}else{
			model = new ModelAndView("fail");
		}
		return model;
	}
	
}
