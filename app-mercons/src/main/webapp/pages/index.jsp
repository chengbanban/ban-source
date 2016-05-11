<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sst首页</title>
</head>
<body>
<h3>welcome!</h3>
进入<a href="<%=basePath %>pages/admin.jsp">admin页面</a>&nbsp;&nbsp;
进入<a href="<%=basePath %>pages/test.jsp">测试页面</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<%=basePath %>logout">退出</a>&nbsp;&nbsp;
<a href="<%=basePath %>toRegister">注册</a>
</body>
</html>