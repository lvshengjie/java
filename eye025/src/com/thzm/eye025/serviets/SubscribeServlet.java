package com.thzm.eye025.serviets;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import com.thzm.eye025.service.ProfessorService;
import com.thzm.eye025.service.SubscribeService;




@WebServlet("/subscribeAbs")
public class SubscribeServlet extends HttpServlet {
	
	DiskFileItemFactory factory;
	String picDir;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		//获取应用全局对象ServletContext
		ServletContext app = config.getServletContext();
		
		picDir = app.getRealPath("/pictures");// getRealPath 返回输入流的绝对地址
		System.out.println(picDir);
		File repository = new File(picDir);
		
		// 设置磁盘缓冲阀值和，缓冲目录。
		factory = new DiskFileItemFactory(1024, repository);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			try {
				List<FileItem> items = upload.parseRequest(request);
				

				String Name;
				String connect;
				String email;
				String gender;
				String age;
				String item;
				String date;
				String  description;
				
				for(int i=0; i<items.size(); i++) {
					FileItem itema = items.get(i);
					
					String name = itema.getFieldName();
					String value = itema.getString();
					
					if("Name".equals(name)) {
						Name = value;
					}else if("connect".equals(name)) {
						connect = value;
					}else if("email".equals(name)) {
						email = value;
					}else if("gender".equals(name)) {
						gender = value;
					}else if("age".equals(name)) {
						age = value;
					}else if("item".equals(name)) {
						item = value;
					}else if("date".equals(name)) {
						date = value;
						
					}else {
						description = value;
					}
				}
				
SubscribeService.pic("Name", "connect", "email", "gender", Integer.parseInt("age"), "item", com.thzm.eye025.Util.Util.parseDate("date"), "description");
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		
	}

	private String ParserData(String value) {
		// TODO Auto-generated method stub
		return null;
	}

}