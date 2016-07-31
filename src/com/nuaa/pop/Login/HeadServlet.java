package com.nuaa.pop.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuaa.pop.Controller.manager;
import com.nuaa.pop.entity.User;
import com.nuaa.pop.utils.DBUtils;

public class HeadServlet extends HttpServlet {

	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("gbk");
	     response.setContentType("text/html; charset=gbk");
	     String userId=request.getParameter("userId");
	     User user=new User();
	     manager ma =new manager();
	     user = ma.queryUserByUserId(userId);
	//     System.out.println(user.getUserId());
//	     if(user.getUserId().equals(null))
//	     {
	     Login.sendUserData(user, response);
//	     	 System.out.println("Not find this user");
//	     }
//	     else
//	     {
//	    	 
//	    	 Login.sendUserData(user, response);
//	    	 System.out.println("Send userHead success");
//	   
//	     }
	}

}
