package com.dev.cty.dao;

import java.util.List;

import com.dev.cty.dto.ReportDto;
import com.dev.cty.entity.Report;

public interface IReportDao {

	List<Report> getReports();

	Report getReport(String repName);

	int addReport(ReportDto repDto, String nowTime);

	int editReport(ReportDto repDto);

	int deleteReport(String repName);

}
