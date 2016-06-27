package com.dev.cty.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dev.cty.dao.BaseDao;
import com.dev.cty.dao.IReportDao;
import com.dev.cty.dto.ReportDto;
import com.dev.cty.entity.Report;

@Repository
public class ReportDaoImpl extends BaseDao<Report> implements IReportDao {


	private static final String SELECT_ALL_REPORT = "select * from report";  
	private static final String SELECT_ONE_REPORT = "select * from report where rep_name=?"; 
	@Override
	public List<Report> getReports() {
		List<Report> list = null;
		try {
			list = this.queryEntityList(SELECT_ALL_REPORT, Report.class, new Object[] {});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Report getReport(String repName) {
		Report rep = (Report)this.queryForObject(SELECT_ONE_REPORT, Report.class, new Object[]{repName});
		return rep;
	}
	@Override
	public int addReport(ReportDto repDto,String nowTime) {
		String insert_one_report = "insert into report(rep_name,rep_url,rep_desc,createDate,createPerson) values(:repName,:repUrl,:repDesc,'"+nowTime+"',:createPerson)";
		
		return this.saveObject(insert_one_report, repDto);
	}
	@Override
	public int editReport(ReportDto repDto) {
		String update_one_report = "update report set rep_url=:repUrl,rep_desc=:repDesc where rep_name=:repName";

		return this.updateObject(update_one_report, repDto);
	}
	@Override
	public int deleteReport(String repName) {
		String delete_one_sql = "delete from report where rep_name=?";
		return this.saveObject(delete_one_sql, new Object[]{repName});
	}

}
