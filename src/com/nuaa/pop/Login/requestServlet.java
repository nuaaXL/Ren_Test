package com.nuaa.pop.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nuaa.pop.Controller.manager;
import com.nuaa.pop.Controller.requestManager;
import com.nuaa.pop.entity.Request;
import com.nuaa.pop.entity.User;

public class requestServlet extends HttpServlet {

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
		String type = request.getParameter("type");
		manager mg = new manager();
		requestManager rM = new requestManager();
		List<Request> requests = new ArrayList<Request>();
        if(type.equals("all")){
        	int num = Integer.parseInt( request.getParameter("num") );
        	requests = rM.queryAllrequest(num);
        	System.out.println("=====in requestServlet: all");
        	sendRequestData(requests,response);
        	
//            request.setAttribute("requests", requests);
//			
//			request.getRequestDispatcher("/test.jsp").forward(request, response);
			
        	
        }
        else if( type.equals("me_p") ){
        	int num = Integer.parseInt( request.getParameter("num") );
        	String userId = request.getParameter("userId");
        	requests = rM.queryMyRequest(num, userId, 1);
        	
        	System.out.println("=====in requestServlet: me_p");
        	sendRequestData(requests,response);
            //request.setAttribute("requests", requests);
			
			//request.getRequestDispatcher("/test.jsp").forward(request, response);

        }else if( type.equals("me_h") ){
        	String userId = request.getParameter("userId");
        	int num = Integer.parseInt( request.getParameter("num") );
            requests = rM.queryMyRequest(num, userId, 2);
        	
            System.out.println("=====in requestServlet: me_h");
        	sendRequestData(requests,response);
            //request.setAttribute("requests", requests);
			
			//request.getRequestDispatcher("/test.jsp").forward(request, response);

        }else if(type.equals("add")){
        	System.out.println("============add==============");
        	User user=new User();				
            Request rq = new Request();
            
        	Date currentTime = new Date();  
        	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm");  
        	String dateString = formatter.format(currentTime);
        	
        	rq.setTime(dateString);
        	System.out.println("requestServlet ln:98");
        	rq.setFlag( Integer.parseInt( request.getParameter("flag") ) );
        	System.out.println("requestServlet ln:100");
        	int point = Integer.parseInt( request.getParameter("point") );
        	System.out.println("requestServlet ln:102");
        	rq.setPoint( point );
        	System.out.println("requestServlet ln:104");
    		String publisher=request.getParameter("publisher");    //ÖÐÎÄ½âÂë
			publisher=new String(publisher.getBytes("iso-8859-1"),"gbk");
        	rq.setPublisher( publisher);
        	String p_number = request.getParameter("p_number");
        	rq.setP_number( p_number );
        	rq.setP_phone( request.getParameter("p_phone") );

        	
        	String user_loc=request.getParameter("user_loc");
        	user_loc=new String(user_loc.getBytes("iso-8859-1"),"gbk");
        	rq.setUser_loc( user_loc );
        	
        	String content= request.getParameter("content") ;
        	content=new String(content.getBytes("iso-8859-1"),"gbk");
        	System.out.println("--------content:"+content);
        	if( rM.checkContent(content)>=0 ){
        		user.setUserId("-2");
        		Login.sendUserData(user, response);
        		return;
        	}        	
        	rq.setContent(content);
        	
        	String infor= request.getParameter("infor")  ;
        	infor=new String(infor.getBytes("iso-8859-1"),"gbk");
        	rq.setInfor(infor );
        	
        	String r_nameORmessage= request.getParameter("r_nameORmessage")  ;
        	r_nameORmessage=new String(r_nameORmessage.getBytes("iso-8859-1"),"gbk");
        	rq.setR_nameORmessage( r_nameORmessage);
        	
        	String r_locORpackage_loc= request.getParameter("r_locORpackage_loc")  ;
        	r_locORpackage_loc=new String(r_locORpackage_loc.getBytes("iso-8859-1"),"gbk");
        	rq.setR_locORpackage_loc( r_locORpackage_loc );
        	
        	String r_phoneORphone= request.getParameter("r_phoneORphone")  ;
        	r_phoneORphone=new String(r_phoneORphone.getBytes("iso-8859-1"),"gbk");
        	rq.setR_phoneORphone( r_phoneORphone);
        	
        	String nullORpackage_Id= request.getParameter("nullORpackage_Id")  ;
        	nullORpackage_Id=new String(nullORpackage_Id.getBytes("iso-8859-1"),"gbk");
        	rq.setNullORpackage_Id( nullORpackage_Id );
        	
        	rq.setUrl(request.getParameter("url"));
        	
        	
        	
        	user.setPoint( mg.payPoint(p_number, point) );
        	user.setUserId("1");
        	
        	rM.addRequest(rq);
        	
        	Login.sendUserData(user, response);
//        	request.getRequestDispatcher("/Error.jsp").forward(request, response);

        }
        else {
        	
        	System.out.println("error");
        }
	}
	
	public List<Map<String, Object>> acking(List<Request> requests)
	{
		List<Map<String,Object>> req=new ArrayList<Map<String,Object>>();
		Request mid=new Request();
		for(int i=0;i<requests.size();i++)
		{
			Map<String,Object> map=new HashMap<String,Object>();
			mid=requests.get(i);
			map.put("num", mid.getNum());
			map.put("time", mid.getTime());
			map.put("flag", mid.getFlag());
			map.put("publisher", mid.getPublisher());
			map.put("p_number", mid.getP_number());
			map.put("p_phone",mid.getP_phone());
			map.put("helper", mid.getHelper());
			map.put("h_number", mid.getH_number());
			map.put("h_phone", mid.getH_phone());
			map.put("user_loc", mid.getUser_loc());
			map.put("content", mid.getContent());
			map.put("info", mid.getInfor());
			map.put("r_nameORmessage", mid.getR_nameORmessage());		
			map.put("r_locORpackage_loc", mid.getR_locORpackage_loc());
			map.put("r_phoneORphone", mid.getR_phoneORphone());
			map.put("nullORpackage", mid.getNullORpackage_Id());
			req.add(map);
		}
		return req;
	}

	
	public static void sendRequestData(List<Request> list, HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();

		// ï¿½ï¿½ï¿½Íµï¿½list×ªï¿½ï¿½Îªjson
		String s2 = gson.toJson(list);
	
		System.out.println("-----list----json==" + s2);
		
		out.println(s2);
	}
	
}
