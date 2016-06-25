package com.dev.cty.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.cty.dto.ReportDto;
import com.dev.cty.entity.Report;
import com.dev.cty.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {

	@Override
	public List<Report> getReports() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyt_analyze", "root", "1234");
			Statement sta = conn.createStatement();
			String sql = "select * from report";
			ResultSet rs = sta.executeQuery(sql);
			
			List<Report> reports = new ArrayList<>();
			while (rs.next()) {
				Report rep = new Report();
				rep.setRepName(rs.getString("rep_name"));
				rep.setRepUrl(rs.getString("rep_url"));
				rep.setRepDesc(rs.getString("rep_desc"));
				rep.setCreateDate(rs.getDate("createDate"));
				rep.setCreatePerson(rs.getString("createPerson"));
				reports.add(rep);
			}
			rs.close();
			sta.close();
			conn.close();
			return reports;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Report getReport(String repName) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyt_analyze", "root", "1234");
			Statement sta = conn.createStatement();
			String sql = "select * from report where rep_name='"+repName+"'";
			ResultSet rs = sta.executeQuery(sql);
			
			Report rep = new Report();
			while (rs.next()) {
				rep.setRepName(rs.getString("rep_name"));
				rep.setRepUrl(rs.getString("rep_url"));
				rep.setRepDesc(rs.getString("rep_desc"));
				rep.setCreateDate(rs.getDate("createDate"));
				rep.setCreatePerson(rs.getString("createPerson"));
			}
			rs.close();
			sta.close();
			conn.close();
			return rep;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addReport(ReportDto repDto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyt_analyze", "root", "1234");
			Statement sta = conn.createStatement();
			Date date = new Date();//获得系统时间.
	        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

			String sql = "insert into report values('"+repDto.getRepName()+"','"+repDto.getRepUrl()+"','"+repDto.getRepDesc()+"','"+nowTime+"','"+repDto.getCreatePerson()+"')";
			int a = sta.executeUpdate(sql);
			sta.close();
			conn.close();
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int editReport(ReportDto repDto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyt_analyze", "root", "1234");
			Statement sta = conn.createStatement();
			Date date = new Date();//获得系统时间.
	        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

			String sql = "update report set rep_url='"+repDto.getRepUrl()+"',rep_desc='"+repDto.getRepDesc()+"',createDate='"+nowTime+"' where rep_name='"+repDto.getRepName()+"'";
			int a = sta.executeUpdate(sql);
			sta.close();
			conn.close();
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int deleteReport(String repName) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyt_analyze", "root", "1234");
			Statement sta = conn.createStatement();
			Date date = new Date();//获得系统时间.
	        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

			String sql = "delete from report where rep_name='"+repName+"'";
			int a = sta.executeUpdate(sql);
			sta.close();
			conn.close();
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
