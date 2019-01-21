<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	<h1>预约管理</h1>
	<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>
	<form action="subscribeAbs" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="Name"></td>
			</tr>
			<tr>
				<td>联系电话：</td>
				<td><input type="text" name="conner"></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><input type="text" name="gender"></td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>预约项目：</td>
				<td><input type="text" name="item"></td>
			</tr>
			<tr>
				<td>预约日期：</td>
				<td><input type="text" name="date"></td>
			</tr>
			<tr>
				<td>病情描述：</td>
				<td><textarea rows="5" cols="100" name=" description"></textarea></td>
			</tr>
			<tr>
				
				<td><input type="submit" value="提交" ></td>
			</tr>
		</table>
	</form>
	
</body>
</html>