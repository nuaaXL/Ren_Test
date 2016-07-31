package com.nuaa.pop.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nuaa.pop.Controller.manager;
import com.nuaa.pop.entity.User;

public class Login extends HttpServlet {

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
	 * @param response 
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public static void sendUserData(User user, HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		List<User> list = new ArrayList<User>();
		list.add(user);
		Gson gson = new Gson();

		// ���͵�listת��Ϊjson
		String s2 = gson.toJson(list);
	
		System.out.println("-----list----json==" + s2);
		
		out.println(s2);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	request.setCharacterEncoding("UTF-8");
		 request.setCharacterEncoding("gbk");
		   response.setContentType("text/html;charset=gbk");
		System.out.println("===============in Login================");
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		manager mg = new manager();
		User user = null;
		user = mg.queryUserByUserId(userId);
	//	System.out.println(user.getUserId());
	//	System.out.println(user.getPasswd());
		if( (user != null) && passwd.equals( user.getPasswd() ) ){
			
//			request.setAttribute("user", user);
//			request.getRequestDispatcher("/Success.jsp").forward(request, response);
			sendUserData(user,response);
		}
		else if (user==null){
			user =new User();
			user.setUserId("-1");
			sendUserData(user,response);
		//	request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		else
		{
			user = new User();
			user.setUserId("-2");
			sendUserData(user,response);
		}
	}

}
