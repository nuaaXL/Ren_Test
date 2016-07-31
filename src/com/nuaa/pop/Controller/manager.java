package com.nuaa.pop.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.nuaa.pop.entity.User;
import com.nuaa.pop.utils.DBUtils;


public class manager {
    
    public User queryUserByUserId(String userId){
    	User user = null;
    	Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		DBUtils tool = new DBUtils();
    	try {
    		
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection( tool.getSs(), tool.getUsername(), tool.getpAssWd() );                   
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from user where userId='"+userId+"';");
			
            if(rs.next()){
				
				user = new User();
				
				user.setUserId(userId);
				
				user.setName(rs.getString("name"));
				
				user.setGender(rs.getInt("gender"));
				
				user.setPasswd(rs.getString("passwd"));
				
				user.setPhone(rs.getString("phone"));
				
				user.setPoint(rs.getInt("point"));
				
				user.setSchool(rs.getString("school"));
				
				user.setUrl(rs.getString("url"));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.release(rs, stmt, conn);
		}
    	return user;
    }
    
    public void modifyPicUrl(User user)
    {
    	Connection conn = null;
		Statement stmt = null;
		DBUtils tool = new DBUtils();
    	try {
			
    		Class.forName("com.mysql.jdbc.Driver");
				
			conn = DriverManager.getConnection( tool.getSs(), tool.getUsername(), tool.getpAssWd() );                   
			
			stmt = conn.createStatement();
			
			String str="update user set url='"+user.getUrl()+"'where userId ='"+user.getUserId()+"';";
			System.out.println(str);
			stmt.executeUpdate(str);
			System.out.println("Moddify picture URL success");
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
	
		
		
    	
    }
    
    
    public int modifyUser(User user){
    	int res = 0;
    	Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		DBUtils tool = new DBUtils();
    	try {
    		
			Class.forName("com.mysql.jdbc.Driver");			
			
			conn = DriverManager.getConnection( tool.getSs(), tool.getUsername(), tool.getpAssWd() );
			stmt = conn.createStatement();
			System.out.println("===========in modifyUser===============");
			String strUpdate = "update user set name='"+user.getName()+"' , passwd='"+user.getPasswd()+"', gender="+user.getGender()+" , phone='"+user.getPhone()+"' , school='"+user.getSchool()+"' where userId='"+user.getUserId()+"'";
			System.out.println(strUpdate);
			res = stmt.executeUpdate(strUpdate);
			System.out.println("===========in modifyUser2===============");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtils.release(rs, stmt, conn);
		}
    	System.out.println("===========end modifyUser, res = "+res+"===============");
    	return res;
    }
    
    public int addUser(User user){
    	int res = 0;
    	Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		DBUtils tool = new DBUtils();
    	try {
    		
			Class.forName("com.mysql.jdbc.Driver");			
			
			conn = DriverManager.getConnection( tool.getSs(), tool.getUsername(), tool.getpAssWd() );
			stmt = conn.createStatement();
			System.out.println("===========in addUser===============");
			
			String strAdd = "insert into user values ('"+user.getUserId()+"' ,'"+user.getName()+"', '"+user.getPasswd()+"', "+user.getGender()+", '"+user.getPhone()+"', '"+user.getSchool()+"', 20,'"+user.getUrl()+"')";
			
			System.out.println(strAdd);
			res = stmt.executeUpdate(strAdd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtils.release(rs, stmt, conn);
		}
    	System.out.println("===========end addUser, res = "+res+"===============");
    	return res;
    }
    
    public int payPoint(String userId, int point){
    	
    	Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int newpoint=0;
		int res=0;
		DBUtils tool = new DBUtils();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection( tool.getSs(), tool.getUsername(), tool.getpAssWd() );
			stmt = conn.createStatement();
			System.out.println("===========in payPoint===============");
			rs = stmt.executeQuery("select * from user where userId='"+userId+"';");
			System.out.println("select * from user where userId='"+userId+"';");
			rs.last();
			newpoint = rs.getInt("point");
			System.out.println("the user point = "+newpoint);
			newpoint = newpoint - point;
			String strUpdate = "update user set point="+newpoint+" where userId='"+userId+"';";
			System.out.println(strUpdate);
			res = stmt.executeUpdate(strUpdate);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.release(rs, stmt, conn);
		}
		System.out.println("===========end payPoint, res = "+res+"===============");
    	if(res == 0)
		    return res;
    	else return newpoint;
    }
    
    public int recharge(String userId, int point){
    	Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		DBUtils tool = new DBUtils();
		int res = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection( tool.getSs(), tool.getUsername(), tool.getpAssWd() );
			stmt = conn.createStatement();
			System.out.println("===========in recharge===============");
			rs = stmt.executeQuery("select * from user where userId='"+userId+"';");
			System.out.println("select * from user where userId='"+userId+"';");
			rs.last();
			point+=rs.getInt("point");
			String strUpdate = "update user set point= "+point+" where userId='"+userId+"' ;";
			System.out.println(strUpdate);
			res = stmt.executeUpdate(strUpdate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.release(rs, stmt, conn);
		}
    	
		System.out.println("===========end recharge===============");
    	return res;
    }
    
}
