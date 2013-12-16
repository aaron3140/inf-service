<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" scope="request"
	value="${pageContext.request.contextPath}" />
<html>
	<head>
	<title>前置INF工具箱</title>
	<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/inf.css" />
	</head>
	<body class="html">
		<div id="wrapper">
			<div id="maincontent">
				<div>
					<h2>前置INF工具箱:</h2>
					<p>操作说明。</p>
				</div>
				<div>
				    <ul>
					<li><a href="requestClnregLog.jsp">验证码查询---在线注册/登录</a> </li>
					</ul>
					<ul>
					<li><a href="requestPassword.jsp">密码查询---POS加密密码</a></li>
					</ul>
					<ul>
					<li><a href="requestBindCard.jsp">注册绑卡查询</a></li>
					</ul>
				</div>
			</div>
		</div>
	</body>
</html>