<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
<sec:authentication property="principal" var="authentication"/>
<sec:authorize ifAllGranted="ROLE_USER">可以访问</sec:authorize>
用户：${authentication.username }<br /> 欢迎<sec:authentication property="name"/>!<br>
欢迎来到测试页面. <br>
</body>
</html>