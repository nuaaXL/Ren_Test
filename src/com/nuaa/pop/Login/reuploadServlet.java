package com.nuaa.pop.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.nuaa.pop.utils.DBUtils;

public class reuploadServlet extends HttpServlet {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	DBUtils tool = new DBUtils();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根
		doPost(req,resp);
	}
	
	public int GetNum()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection( tool.getSs(), tool.getUsername(), tool.getpAssWd() );                   
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from picture_num;");

			rs.last();
			int i=rs.getInt("req");
			i++;
			System.out.println(i);
			String str="update picture_num set req='"+i+"'where req='"+(i-1)+"';";
			System.out.println(str);
			stmt.executeUpdate(str);
			return i;
		
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
			return 0;
	}
	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 request.setCharacterEncoding("gbk");
	        response.setContentType("text/html; charset=gbk");
	        SmartUpload smartUpload = new SmartUpload();
	        try {
		            smartUpload.initialize(this.getServletConfig(), request, response);
		            smartUpload.upload();
		            com.jspsmart.upload.File smartFile = smartUpload.getFiles().getFile(0);
		            if (!smartFile.isMissing()) {
		           	int i=GetNum();
		           	System.out.println("-------i="+i);
		            i++;
		        	System.out.println("-------i="+i);
	            	//String serverPath = request.getSession().getServletContext().getRealPath(".");
	            	System.out.println("------------------img reupload ...");
	            	String str=i+"";
	            	System.out.println(str);
	                String saveFileName = "c:/nuaaxl/request/" + str+".jpg";
	                smartFile.saveAs(saveFileName, SmartUpload.SAVE_PHYSICAL);
	                System.out.println("------------------img upload ...");
	                // print multipart parameter
	                saveFileName=str+".jpg";
	                response.getWriter().print(saveFileName);
//	                User user=new User();
//	                user.setUserId(i+"");
//	                user.setUrl(saveFileName);
//	                Login.sendUserData(user, response);
	 //               UpdateNum(i);
	                //+ ", msg: " + smartUpload.getRequest().getParameter("msg"));
	            } else {
	                response.getWriter().print("missing...");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("------------------img Exception ...");
	        }
	    }


}
