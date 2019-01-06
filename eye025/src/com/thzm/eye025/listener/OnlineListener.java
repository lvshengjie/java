package com.thzm.eye025.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class OnlineListener implements HttpSessionListener {

    
   
	
    public void sessionCreated(HttpSessionEvent evt)  { 
    	ServletContext app=evt.getSession().getServletContext();
    	int count=(int) app.getAttribute("count");
    	app.setAttribute("count", count+1);
    	System.out.println("++++++++++++++++++++");
    }

	
    public void sessionDestroyed(HttpSessionEvent evt)  { 
        ServletContext app=evt.getSession().getServletContext();
        int count=(int) app.getAttribute("count");
        app.setAttribute("count", count-1);
        System.out.println("---------------------");
        System.out.println("source:"+evt.getSource());
        Object o= evt.getSession().getAttribute("userInfo");
        if(o!=null) {
        	System.out.println("在会话销毁时，取得了会话中的数据");
        }else {
        	System.out.println("在会话销毁时，没有取得了会话中的数据");
        }
    }
	
}
