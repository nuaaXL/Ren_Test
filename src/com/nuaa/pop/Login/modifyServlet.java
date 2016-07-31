package com.nuaa.pop.Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuaa.pop.Controller.manager;
import com.nuaa.pop.entity.User;
import com.nuaa.pop.Login.Login;
public class modifyServlet extends HttpServlet {

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
		   request.setCharacterEncoding("gbk");
		   response.setContentType("text/html;charset=gbk");
		   String actionCode = request.getParameter("actionCode");
		   if(actionCode.equals("modifyConfirm")){
			
			String userId = request.getParameter("userId");
			int gender = Integer.parseInt(request.getParameter("gender"));
			String passwd = request.getParameter("passwd");
			String phone = request.getParameter("phone");
			String name= request.getParameter("name");
			name=new String(name.getBytes("iso-8859-1"),"gbk");
			System.out.println(name);
			String school = request.getParameter("school");       //中文解码
			school=new String(school.getBytes("iso-8859-1"),"gbk");
			
			manager mg = new manager();
			User user = new User();
			
			
			user.setUserId(userId);
			user.setGender(gender);
			user.setName(name);
			user.setPasswd(passwd);
			user.setPhone(phone);
			user.setSchool(school);
			
			
			System.out.println("============in modifyServlet================");
			int res = mg.modifyUser(user);
			if(res >= 1){
				user =new User();
				user.setUserId("1");
				Login.sendUserData(user, response);
				
//				request.setAttribute("user", user);
//				request.getRequestDispatcher("/Success.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/Error.jsp").forward(request, response);
			}
		}
		   else if(actionCode.equals("pic_apply"))
		   {
				String userId = request.getParameter("userId");
				String url=request.getParameter("url");
				User user=new User();
				user.setUserId(userId);
				user.setUrl(url);
				manager mg = new manager();
				mg.modifyPicUrl(user);
				user.setUserId("1");
				Login.sendUserData(user, response);
				
		   }
		 else if(actionCode.equals("modify")){
			String userId = request.getParameter("userId");
			manager mg = new manager();
			User user = mg.queryUserByUserId(userId);
			
			request.setAttribute("user", user);
			request.getRequestDispatcher("/modify.jsp").forward(request, response);
		    
		}else if(actionCode.equals("delete")){
			
		}else if(actionCode.equals("register")){
			
			String userId = request.getParameter("userId");
			
			User user = null;
			manager mg = new manager();
			user = mg.queryUserByUserId(userId);
			if(user == null){
				user = new User();
				user.setUserId(userId);
				String name=request.getParameter("name");    //中文解码
				name=new String(name.getBytes("iso-8859-1"),"gbk");
				System.out.println(name);
				user.setName(name);
				user.setGender( Integer.parseInt( request.getParameter("gender") ) );
				user.setPasswd( request.getParameter("passwd") );
				user.setPhone( request.getParameter("phone") );
				String school = request.getParameter("school");       //中文解码
				school=new String(school.getBytes("iso-8859-1"),"gbk");
				user.setSchool(school);
				user.setPoint(20);
				user.setUrl(request.getParameter("url"));
				System.out.println(user.getName());
				System.out.println(user.getPasswd());
				System.out.println(user.getGender());
				System.out.println(user.getSchool());
				System.out.println(user.getPoint());
				System.out.println(user.getPhone());
				int res = mg.addUser(user);
				if(res >= 1){
					user.setUserId("1");
					Login.sendUserData(user,response);
//					request.setAttribute("user", user);
//					request.getRequestDispatcher("/Success.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("/Error.jsp").forward(request, response);
				}
			}else {
				System.out.println("the userId has been used");
				user.setUserId("-1");
				Login.sendUserData(user, response);
//				request.getRequestDispatcher("/Error.jsp").forward(request, response);
			}
			
		}else if(actionCode.equals("recharge")){
			System.out.println("================in recharge====================");
			String userId = request.getParameter("userId");
			int addPoint = Integer.parseInt(request.getParameter("addPoint"));
			User user = new User();
			manager mg = new manager();
			int res = mg.recharge(userId, addPoint);
			user.setUserId(""+res);
			Login.sendUserData(user, response);
		}
		

		
	}

}
