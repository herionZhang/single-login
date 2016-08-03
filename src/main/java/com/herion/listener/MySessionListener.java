package com.herion.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.herion.entity.SingleLogin;

public class MySessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent event) {
		
		System.out.println("session create---herion-->"+event.getSession().getId());
	}

	@SuppressWarnings("unchecked")
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("session 监听销毁");
		ServletContext appliction=event.getSession().getServletContext();
		
		List<SingleLogin> list=(List<SingleLogin>) appliction.getAttribute("list");
		for (int i = 0; i < list.size(); i++) {
			SingleLogin single = list.get(i);
			//if (single.getType()==0) {
				System.out.println("single=="+single.toString());
				list.remove(single);
			//}
		}
	
		appliction.setAttribute("list", list);
	}

}
