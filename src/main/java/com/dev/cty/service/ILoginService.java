package com.dev.cty.service;

import java.util.List;

import com.dev.cty.entity.Report;

public interface ILoginService {

	List<Report> getReports();

	Report getReport(String repName);

	int addReport(Report rep);

}
