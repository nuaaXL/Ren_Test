package com.nuaa.pop.Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuaa.pop.Controller.helpManager;
import com.nuaa.pop.Controller.requestManager;
import com.nuaa.pop.entity.User;

public class helpServlet extends HttpServlet {

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

		doPost(request, response);
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

		User user = new User();
		requestManager rM = new requestManager();
		helpManager hM = new helpManager();
		
		String type = request.getParameter("type");		
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		if(type.equals("tohelp")){
			System.out.println("===================in helpServlet:  tohelp=============");
			
			String h_number = request.getParameter("h_number");
			
			user.setUserId( h_number );
			
			String name = request.getParameter("helper");//解码
			name = new String(name.getBytes("iso-8859-1"),"gbk");
			user.setName(name);
			
			user.setPhone(request.getParameter("h_phone"));
			
			if(rM.checkAdd_Flag(num, 0, 0)==0){
				user.setUserId("-1");
				Login.sendUserData(user, response);
			}
			//检查flag项是否正确 并变更flag项
			else {
				int mm = hM.tohelp(user, num);
			    user.setUserId( mm+"" );
			    if( mm==1 )rM.checkAdd_Flag(num, 0, 10);
			    Login.sendUserData(user, response);
			}
		}else if(type.equals("helped")){
			System.out.println("===================in helpServlet:  helped=============");

			if(rM.checkAdd_Flag(num, 10, 10)==0){
				user.setUserId("-1");
				Login.sendUserData(user, response);
			}else {
				int mm = hM.helped(num);
				user.setUserId( mm+"" );
				if( mm==1 )rM.checkAdd_Flag(num, 10, 20);
			    Login.sendUserData(user, response);
			}
		}
	}

}
