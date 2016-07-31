package com.nuaa.pop.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nuaa.pop.entity.Request;
import com.nuaa.pop.entity.User;
import com.nuaa.pop.utils.DBUtils;

public class requestManager {
    public List queryAllrequest(int num){

    	int mid=num;
    	List requests = null;
    	Request rq = null;
    	
    	if(num == 0){
			rq = new Request();
			requests = new ArrayList();
			rq.setNum(0);
			requests.add(rq);
			return requests;
		}
    	
    	Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		DBUtils tool = new DBUtils();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			conn = DriverManager.getConnection( tool.getSs(), tool.getUsername(), tool.getpAssWd() );
			stmt = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
			//stmt = conn.createStatement();
			
			System.out.println("============mid mid mid ="+mid);

			rs = stmt.executeQuery("select * from request where (flag%100)<10;");
			rs.last();
			mid = rs.getInt("num");
			
			if(num>0 && num<mid){
				while(mid>num){
					rs.previous();
					mid = rs.getInt("num");
				}
			}
			else {
				num = mid;
			}
			//rs.previous();
			
            System.out.println("====num = "+num);
            //if( rs.next() )System.out.println("====mid = "+mid);;
            //rs.next() &&
            int i = 0;
            requests = new ArrayList();
            while( i<10 ){
            	
            	rq = new Request();
            	System.out.println("==========================================");
            	rq.setNum(rs.getInt("num"));
            	
            	System.out.println("===================================rq.num="+rs.getInt("num"));
            	rq.setTime(rs.getString("time"));
            	rq.setFlag(rs.getInt("flag"));
            	rq.setPoint(rs.getInt("point"));
            	rq.setPublisher(rs.getString("publisher"));
            	rq.setP_number(rs.getString("p_number"));
            	rq.setP_phone(rs.getString("p_phone"));
            	rq.setHelper(rs.getString("helper"));
            	rq.setH_number(rs.getString("h_number"));
            	rq.setH_phone(rs.getString("h_phone"));
            	rq.setUser_loc(rs.getString("user_loc"));
            	rq.setContent(rs.getString("content"));
            	rq.setInfor(rs.getString("infor"));
            	rq.setR_nameORmessage(rs.getString("r_nameORmessage"));
            	rq.setR_locORpackage_loc(rs.getString("r_locORpackage_loc"));
            	rq.setR_phoneORphone(rs.getString("r_phoneORphone"));
            	rq.setNullORpackage_Id(rs.getString("nullORpackage_Id"));
            	rq.setUrl(rs.getString("url"));
            	i++;
            	requests.add(rq);
            	rs.previous();
            	//rs = stmt.executeQuery("select * from request_todo where num = "+mid+";");
            	//System.out.println("select * from request_todo where num = "+mid+";");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
			DBUtils.release(rs, stmt, conn);
		}
		if(requests == null){
			System.out.println("=============requests == null===============");
			rq = new Request();
			requests = new ArrayList();
			rq.setNum(0);
			System.out.println("rq.num = "+rq.getNum());
			requests.add(rq);
		}
    	return requests;
    }
    
    public int checkContent(String content){
    	int res = -1;
    	String []word = {"任增良", "鼠标", "逗比", "键盘", "炸弹"};
    	for(int i = 0; i<word.length; i++ ){
    		    		
    		//word[i] = new String (word.getBytes("iso-8859-1"),"gbk");
    		res = content.indexOf(word[i]);
    		if(res>=0)break;
    	}
    	    
    	return res;
    }

    
    
    
    public List queryMyRequest(int num, String userId, int flag){
    	 
    	System.out.println("====================in queryMyRequest=========================");
    	int mid = num;
    	List requests = null;
    	Request rq = null;
    	
    	if(num == 0){
			rq = new Request();
			requests = new ArrayList();
			rq.setNum(0);
			requests.add(rq);
			return requests;
		}
    	
    	Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		DBUtils tool = new DBUtils();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			conn = DriverManager.getConnection( tool.getSs(), tool.getUsername(), tool.getpAssWd() );
			stmt = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
			//stmt = conn.createStatement();
			
			System.out.println("============mid mid mid ="+mid);
            if(flag%10 == 1){
			    rs = stmt.executeQuery("select * from request where p_number='"+userId+"';");
			    System.out.println("select * from request where p_number='"+userId+"';");
            } else {
            	rs= stmt.executeQuery("select * from request where h_number='"+userId+"';");
			    System.out.println("select * from request where h_number='"+userId+"';");
            }
			rs.last();
			mid = rs.getInt("num");
			
			if(num>0 && num<mid){
				while(mid>num){
					rs.previous();
					mid = rs.getInt("num");
				}
			}
			else {
				num = mid;
			}
			//rs.previous();
			
            System.out.println("====num = "+num);
            //if( rs.next() )System.out.println("====mid = "+mid);;
            //rs.next() &&
            int i = 0;
            requests = new ArrayList();
            while( true ){
            	
            	rq = new Request();
            	System.out.println("==========================================");
            	rq.setNum(rs.getInt("num"));
                
            	System.out.println("===================================rq.num="+rs.getInt("num"));
            	rq.setTime(rs.getString("time"));
            	rq.setFlag(rs.getInt("flag"));
            	rq.setPoint(rs.getInt("point"));
            	rq.setPublisher(rs.getString("publisher"));
            	rq.setP_number(rs.getString("p_number"));
            	rq.setP_phone(rs.getString("p_phone"));
            	rq.setHelper(rs.getString("helper"));
            	rq.setH_number(rs.getString("h_number"));
            	rq.setH_phone(rs.getString("h_phone"));
            	rq.setUser_loc(rs.getString("user_loc"));
            	rq.setContent(rs.getString("content"));
            	rq.setInfor(rs.getString("infor"));
            	rq.setR_nameORmessage(rs.getString("r_nameORmessage"));
            	rq.setR_locORpackage_loc(rs.getString("r_locORpackage_loc"));
            	rq.setR_phoneORphone(rs.getString("r_phoneORphone"));
            	rq.setNullORpackage_Id(rs.getString("nullORpackage_Id"));
            	rq.setUrl(rs.getString("url"));
            	i++;
            	requests.add(rq);
            	rs.previous();
            	//rs = stmt.executeQuery("select * from request_todo where num = "+mid+";");
            	//System.out.println("select * from request_todo where num = "+mid+";");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
			DBUtils.release(rs, stmt, conn);
		}
		if(requests == null){
			requests = new ArrayList();
			rq = new Request();
			rq.setNum(0);
			requests.add(rq);
		}
    	return requests;
    }

    public int addRequest(Request rq){
    	int res = 0;
    	Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		DBUtils tool = new DBUtils();
    	try {
    		
			Class.forName("com.mysql.jdbc.Driver");			
			
			conn = DriverManager.getConnection( tool.getSs(), tool.getUsername(), tool.getpAssWd() );
			stmt = conn.createStatement();
			System.out.println("===========in addRequest===============");
			
			String strAdd = "insert into request (time, flag, point, publisher, p_number, p_phone, user_loc, content, infor, r_nameORmessage, r_locORpackage_loc, r_phoneORphone, nullORpackage_Id,url) values ('"+rq.getTime()+"' ,"+rq.getFlag()+", "+rq.getPoint()+", '"+rq.getPublisher()+"', "+rq.getP_number()+", '"+rq.getP_phone()+"', '"+rq.getUser_loc()+"', '"+rq.getContent()+"', '"+rq.getInfor()+"', '"+rq.getR_nameORmessage()+"', '"+rq.getR_locORpackage_loc()+"', '"+rq.getR_phoneORphone()+"', '"+rq.getNullORpackage_Id()+"', '"+rq.getUrl()+"');";
			
			System.out.println(strAdd);
			res = stmt.executeUpdate(strAdd);
			System.out.println(strAdd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtils.release(rs, stmt, conn);
		}
		
    	return res;
    }
    
    
    //判断num的request的flag的十位是否与flag1相等，是则更改成flag2的十位，否则返回0
    public int checkAdd_Flag(int num, int flag1, int flag2){
    	Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int res = 0;
		int flag=0;
		System.out.println("================in checkAdd_Flag================");
		
		DBUtils tool = new DBUtils();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
				
			conn = DriverManager.getConnection( tool.getSs(), tool.getUsername(), tool.getpAssWd() );                   
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from request where num="+num+";");
			System.out.println("select * from request where num="+num+";");
			rs.last();
			flag = rs.getInt("flag");
			
			if(flag%100 >= flag1+10 || flag%100<flag1){
				System.out.println("error: flag%100>=10");
				DBUtils.release(rs, stmt, conn);
				return 0;
			}
			flag += flag2 - flag1;
			String strUpdate = "update request set flag="+flag+" where num="+num+";";
			System.out.println(strUpdate);
			res = stmt.executeUpdate(strUpdate);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.release(rs, stmt, conn);
		}
		System.out.println("================end checkAdd_Flag================");
    	return res;
    }
    
}
