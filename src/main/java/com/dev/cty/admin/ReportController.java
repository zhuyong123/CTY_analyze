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

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/ReportController.do")
public class ReportController {
	@Autowired
	IReportService irs;
	@RequestMapping(params="method=showReports")
	protected ModelAndView toshowReports(HttpServletRequest request,HttpServletResponse response){
		List<Report> reports = irs.getReports();
		request.setAttribute("reports", reports);
		ModelAndView model = new ModelAndView("showReports");
		return model;
	}
	@RequestMapping(params="method=addReportPage")
	protected ModelAndView toAddReportPage(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView("addReportPage");
		return model;
	}
	
	
	@RequestMapping(params="method=addReport")
	protected ModelAndView toAddReport(ReportDto repDto,HttpServletRequest request){

		int a = irs.addReport(repDto);
		ModelAndView model = null;
		if (a==1) {
			model = new ModelAndView("redirect:/ReportController.do?method=showReports");
		}else{
			model = new ModelAndView("fail");
		}
		return model;
	}
	@RequestMapping(params="method=editPage")
	protected ModelAndView toEditPage(String repName,HttpServletRequest request){
		Report rep = irs.getReport(repName);
		request.setAttribute("rep",rep );
		ModelAndView model = new ModelAndView("editPage");
		return model;
	}
	@RequestMapping(params="method=editReport")
	protected ModelAndView toEditReport(ReportDto repDto,HttpServletRequest request){
		int a = irs.editReport(repDto);
		
		ModelAndView model = null;
		if (a==1) {
			model = new ModelAndView("redirect:/ReportController.do?method=showReports");
		}else{
			model = new ModelAndView("fail");
		}
		return model;
	}
	
	@RequestMapping(params="method=deleteReport")
	protected ModelAndView toDeleteReport(String repName,HttpServletRequest request){
		int a = irs.deleteReport(repName);
		
		ModelAndView model = null;
		if (a==1) {
			model = new ModelAndView("redirect:/ReportController.do?method=showReports");
		}else{
			model = new ModelAndView("fail");
		}
		return model;
	}
	@RequestMapping(params="method=getReports")
	protected String toGetReports(HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<Report> reports = irs.getReports();
		JSONArray js = JSONArray.fromObject(reports);
		System.out.println(js);
		return sendMessages(response,js);
	}
	
	public String sendMessages(HttpServletResponse response, Object json)
    		throws Exception {
    		response.setContentType("application/json");
    		response.setContentType("text/json; charset=utf-8");
    		response.setCharacterEncoding("UTF-8");
    		response.getWriter().print(json);
    		return null;
	}
}
