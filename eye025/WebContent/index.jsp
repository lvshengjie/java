<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>EyE眼科</title>
</head>

	<style>
		html,body{
			width: 100%;
			height: 100%;
			font-size: 12px;
		}

		body{
			display: flex;;
			flex-direction: row;
			align-items: center;
			justify-content: center;
		}
		.panel{
			width: 80%;
			height: 80%;
			
		}
		table{
			width: 100%;
			font-size:2em;
			background:#ef2929ff;
		}
		td{
			width:30%;
			height: 3em;
		}
		input{
			height: 2em;
		}
		td:nth-child(1){
			text-align: right;
		}
		.input{
			width: 300px;
		}
		.btn{
			font-size: 1em;
			margin: 10px;
			padding: 10px;
			border-radius: 5px;
		}
	</style>
	<script >
		function login(f){
			
			var adminNameMsg=document.getElementById("adminNameMsg");
			var passwordMsg=document.getElementById("passwordMsg");
			adminNameMsg.innerText='';
			passwordMsg.innerText='';
			
			var ok=true;
			var adminName=f.adminName.value;
			var regexpName=/^[A-Za-z]{2,20}$/;
			if(!regexpName.test(adminName)){
				ok=false;
				
				adminNameMsg.innerText='登录名格式不正确';
			}
			var pwd=f.password.value;
			var regexpPWD=/^[0-9a-zA-Z]{6,12}$/;
			if(!regexpPWD.test(pwd)){
				ok= false;
				
				passwordMsg.innerText='密码格式不正确';
			}
			
			return login;
		}
	</script>

<body>
	

	<div class="panel">
		<h1>EyE眼科后台管理系统</h1>
		<form action="./login" method="post" onsubmit="return login(this)">
		<table>
			<tr>
				<td>登录名</td>
				<td><input type="text" name="adminName" id="adminName"
				></td>
				<td id="adminNameMsg"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" id="password"></td>
				<td id="passwordMsg"></td>
			</tr>
			<tr>
				<td colspan="3">
<%
		String msg=(String)request.getAttribute("msg");
		if(msg!=null){
			out.println(msg);
		}
%>			
				
				<input type="submit" value="登录" class="btn"></td>
				
			</tr>
		</table>
		</form>
	</div>
	
</body>
</html>