package com.dev.cty.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.cty.dao.IReportDao;
import com.dev.cty.dto.ReportDto;
import com.dev.cty.entity.Report;
import com.dev.cty.service.IReportService;

@Service
public class ReportServiceImpl implements IReportService {

	@Autowired
	private IReportDao reportDao;
	
	
	@Override
	public List<Report> getReports() {

		return reportDao.getReports();
	}

	@Override
	public Report getReport(String repName) {

		return reportDao.getReport(repName);
	}

	@Override
	public int addReport(ReportDto repDto) {
		Date date = new Date();//获得系统时间.
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        int a = reportDao.addReport(repDto,nowTime);
        System.out.println(a);
		return a;
	}

	@Override
	public int editReport(ReportDto repDto) {

		int a = reportDao.editReport(repDto);
		System.out.println(a);
		return a;
	}
	@Override
	public int deleteReport(String repName) {
		return reportDao.deleteReport(repName);
	}
}
