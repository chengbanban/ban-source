<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
<center><h3>用户注册</h3></center><hr/>
	<form action="register" method="POST">
		<table>
			<tr>
				<td>用户名:</td><td>
				<input type='text' name='username'></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type='password' name='password'></td>
			</tr>
			<tr>
				<td><input name="reset" type="reset" value="重置"></td>
				<td><input name="submit" type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>