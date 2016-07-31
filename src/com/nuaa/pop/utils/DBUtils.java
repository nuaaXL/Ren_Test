package com.nuaa.pop.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	String ss = "jdbc:mysql://localhost:3306/nuaaxl?characterEncoding=gbk";
	String username = "root";
	String pAssWd = "root";
public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
public String getSs() {
		return ss;
	}
	public void setSs(String ss) {
		this.ss = ss;
	}
	public String getpAssWd() {
		return pAssWd;
	}
	public void setpAssWd(String pAssWd) {
		this.pAssWd = pAssWd;
	}
public static void release(ResultSet rs, Statement stmt, Connection conn){
		
		
		
		if(rs!=null){
		
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(stmt!=null){
			
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
