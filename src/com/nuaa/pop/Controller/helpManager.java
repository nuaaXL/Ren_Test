package com.nuaa.pop.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.nuaa.pop.entity.User;
import com.nuaa.pop.utils.DBUtils;

public class helpManager {
	public int tohelp(User user, int num)	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		DBUtils tool = new DBUtils();
		int res=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection( tool.getSs(), tool.getUsername(), tool.getpAssWd() );
			stmt = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("select * from request where num="+num+";");
			rs.last();
			System.out.println("select * from request where num="+num+";");
			if( rs.getString("p_number").equals(user.getUserId()) ){
				DBUtils.release(rs, stmt, conn);
				System.out.println("error: publisher and helper is the same one");
				return -2;
			}
			String updata = "update request set helper='"+user.getName()+"' , h_number='"+user.getUserId()+"', h_phone="+user.getPhone()+" where num="+num+";";
			System.out.println(updata);
			res = stmt.executeUpdate(updata);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.release(rs, stmt, conn);
		}
		
		return res;
	}
	
	public int helped(int num) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		DBUtils tool = new DBUtils();
		int res=0;
		int point = 0;
		String userId;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection( tool.getSs(), tool.getUsername(), tool.getpAssWd() );
			stmt = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("select * from request where num="+num+";");
			rs.last();
			System.out.println("select * from request where num="+num+";");
			point = rs.getInt("point");
			userId = rs.getString("h_number");
			rs = stmt.executeQuery("select * from user where userId='"+userId+"';");
			rs.last();
			System.out.println("select * from user where userId="+userId+";");
			res = rs.getInt("point");
			point+=res;
			String strUpdate = "update user set point="+point+" where userId='"+userId+"' ;";
			System.out.println(strUpdate);
			res = stmt.executeUpdate(strUpdate);		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.release(rs, stmt, conn);
		}
		
		return res;
	}

}
