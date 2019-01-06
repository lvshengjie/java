package com.thzm.eye025.serviets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.thzm.eye025.service.AbstaractService;
import com.thzm.eye025.service.DepramentService;


@WebServlet("/depramentAbs")
public class DepramentServlet extends HttpServlet {
	
	DiskFileItemFactory factory;
	String picDir;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		//获取应用全局对象ServletContext
		ServletContext app = config.getServletContext();
		
		picDir = app.getRealPath("/pictures");// 获取/pictures所在的物理路径。
		System.out.println(picDir);
		File repository = new File(picDir);
		
		// 设置磁盘缓冲阀值和，缓冲目录。
		factory = new DiskFileItemFactory(1024, repository);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
			List<FileItem> items = upload.parseRequest(request);//paresRequest(HttpServletRequset)方法可以通过表单每一个HTML签提交的数据封装称一个Filetem对象
			String sname = null ;
			String content = null;
			String piam = null ;
			
			for(int i=0; i<items.size(); i++) {
				FileItem item = items.get(i);
				if(item.isFormField()) { // 是普通form 中的输入元素
					 String name = item.getFieldName();//获取input里面name的值
					
					 String value = item.getString();//获取input里面输入的内容
					 value = new String(value.getBytes("iso-8859-1"),"utf-8"); // 转码。
					 System.out.println(name +":"+value);
					 if("sname".equals(name)) {
		
						sname = value;
					 }
					 else if("content".equals(name)) {
						 content=value;
					 }
				}else { // 是文件
					String getFieldName = item.getFieldName();
					String name = item.getName(); // 取上传的文件名
					name = new String(name.getBytes("iso-8859-1"),"utf-8"); // 转码。
			
					if(!"".equals(name)) {
						// 取随机数为新文件名，与文件名后缀。产生一个新的文件名。
						String prefix = String.valueOf((long)(Math.random()*1000000000000L));
						String surfix = name.substring(name.lastIndexOf("."));
						name = prefix + surfix;
						
						System.out.println(name);
						
						item.write(new File(picDir+"/", name)); // 存文件。
						if("pia".equals(getFieldName)) {
							piam = "/pictures/"+name;
						}
					
					}
					
				}
			}
			boolean publishOk=DepramentService.publish(sname,content,piam);
		} catch ( Exception e) {
			e.printStackTrace();
		}
	}
		
	
}

}