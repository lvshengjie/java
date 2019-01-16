<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	<h1>专家介绍</h1>
	
	<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>
	<form action="professorAbs" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>专家名字</td>
				<td><input type="text" name="Name"></td>
			</tr>
			<tr>
				<td>专家照片</td>
				<td><input type="file" name="photo"></td>
			</tr>
			<tr>
				<td>专家概要</td>
				<td><textarea rows="5" cols="100" name="content"></textarea></td>
			</tr>
			<tr>
				<td>部门Id</td>
				<td><input type="text" name="depid"></td>
			</tr>
			<tr>
				
				<td><input type="submit" value="提交" ></td>
			</tr>
		</table>
	</form>
</body>
</html>