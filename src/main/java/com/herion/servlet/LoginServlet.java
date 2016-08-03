package com.herion.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.herion.entity.SingleLogin;
import com.herion.entity.User;
import com.herion.service.IUserService;
import com.herion.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName=request.getParameter("userName");
		response.setCharacterEncoding("utf-8");
		ServletContext application = request.getSession().getServletContext();
		List<SingleLogin> lists = (List<SingleLogin>) application.getAttribute("list");

		IUserService service = new UserServiceImpl();
		String msg="";
		// 调用业务逻辑
		User user=service.loadUser(userName);
		// 如果admin的ID不为空，就带表数据库中有一记录
		if (user != null) {
			// 把admin存入session中
			if (application.getAttribute("list") != null) {
				for (int i = 0; i < lists.size(); i++) {
					System.out.println("check!!!");
					System.out.println(lists.get(i).toString());
					if (user.getUserName().equals(lists.get(i).getName())) {
						System.out.println("该用户已登录！！");
						msg="该用户已登录！！";
						
						response.setContentType("text/html");
					    response.setCharacterEncoding("utf-8");
					    PrintWriter out = response.getWriter();
					    out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
					    out.println("<HTML>");
					    out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
					    out.println("  <BODY>");
					    out.print(msg);
					    out.println("<a href='../index.jsp'>back</a>");
					    out.println("  </BODY>");
					    out.println("</HTML>");
					    out.flush();
					    out.close();
					    
					    return;
						
					}
				}
			}
			
			SingleLogin sing = new SingleLogin();
			sing.setName(user.getUserName());
			sing.setType(0L);
			
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(30);
			session.setAttribute(userName, user);
			sing.setSession(session);
			if(null==lists){
				 lists=new ArrayList<SingleLogin>();
			}
			lists.add(sing);
			application.setAttribute("list", lists);
			msg="登录成功!!!";
			

		} else {
			msg="用户名或密码错误,或选择的类型有误！！";
		}
		
		
		response.setContentType("text/html");
	    response.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
	    out.println("<HTML>");
	    out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
	    out.println("  <BODY>");
	    out.print(msg);
	    out.println("<a href='../index.jsp'>back</a>");
	    out.println("  </BODY>");
	    out.println("</HTML>");
	    out.flush();
	    out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
