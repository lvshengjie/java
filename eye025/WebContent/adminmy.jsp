<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.thzm.eye025.bean.* ,java.util.List" 

    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style >
		body{
			margin: 
		}
		.header{
			height: 100px;
			background: #562f2f;
			color: white;
			font-size: 40px;
			font-weight: bold;
			text-align: center;
			line-height: 100px;
		}
		.footer{
			height: 100px;
			line-height: 100px;
			text-align: center;
			background: black;
			color: white;
		}
		.center{
			height: 600px;
			display: flex;
			flex-direction: row;
			align-content: stretch;
		}
		.sidebar{
			background: #ccc;
			width:200px;
		}
		.content{
			width: 100%;
		}
	</style>
</head>
<body>
	<div>
			<div class="header">EyE眼科医院网站信息管理</div>
			
			<div style="background: black; color: white;">
				
<%
				Sysadmin user=(Sysadmin)session.getAttribute("userInfo");
				if(null !=user){
				out.print("你好："+ user.getName());
			
%>
					<button type="button" onclick="location='./logout'">退出</button>
					
				
     	      
     	<div style="float:right;">
     	当前在线管理员：
<%
					List<Sysadmin> list  = (List<Sysadmin>)application.getAttribute("adminList");	
						for(int i=0; i<list.size();i++){
	  					Sysadmin u = list.get(i);
	 					 out.print(u.getName()+" &nbsp;");
						}
%> 
		</div>			
					
					
			</div>
			
			
			
			<div class="center">
				<div class="sidebar">
					<ul>
						<li><a href="abstrace.jsp" target="content">医院简介</a></li>
						<li><a href="deprament.jsp" target="content">科室介绍</a></li>
						<li><a href="professor.jsp" target="content">专家介绍</a></li>
						<li><a href="subscribe.jsp" target="content" >预约管理</a></li>
						<li><a href="sysadmin.html" target="content">管理员管理</a></li>
<%
	      if(user.isSuperAdmin()){
%>  
	    	            <li><a href="sysadmin.html" target="content">管理员管理</a></li>
<%
	      }
		}
%>	
						
					</ul>

				</div>
				<iframe  name="content" src="abstrace.jsp" frameborder="0" class="content"></iframe>
			</div>
			<div class="footer">天汇智码软件技术有限公司</div>
	</div>	

</body>
</html>