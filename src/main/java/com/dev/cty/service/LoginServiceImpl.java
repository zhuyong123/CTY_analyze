package com.dev.cty.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.cty.entity.Report;

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
	public int addReport(Report rep) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyt_analyze", "root", "1234");
			Statement sta = conn.createStatement();
			String sql = "insert into report values('"+rep.getRepName()+"','"+rep.getRepUrl()+"','"+rep.getRepDesc()+"','"+rep.getCreateDate()+"','"+rep.getCreatePerson()+"')";
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
