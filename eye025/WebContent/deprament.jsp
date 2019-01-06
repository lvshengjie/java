<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<style >
		h1{
			text-align: center;
		}
	
	</style>
</head>
<body style=" width: 100%">
	<h1>科室介绍</h1>
	
	<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>
<form action="depramentAbs" method="post" enctype="multipart/form-data">
	<table border="0">
		<tr >
			<td>科室名称</td>
			<td><input type="text" name="sname"></td>
			
			
		</tr>
		<tr >
			<td >科室照片</td>
			<td><input type="file" name="pia"></td>
		</tr>
		<tr >
			<td>科室介绍</td>
			<td><textarea rows="5" cols="100" name="content"></textarea></td>
		</tr>
		
		<tr>
				<td><input type="reset" value="清空"></td>
				<td><input type="submit" value="发布"></td>
		</tr>
	</table>
</form>
</body>
</html>