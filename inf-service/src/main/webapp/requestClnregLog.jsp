<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
					<h2>使用说明:</h2>
					<p>操作细则。</p>
				</div>
				<div>
					<h2>在线注册--验证码查询</h2>
					<table  align="center">
						<tr>
							<td>
								<form action="inf/clnregLog/requestClnregLog" method="post">
									手机号码: <input type="text" name="CUST_CODE" />
									<input type="submit" value="查询一下" />
								</form>
							</td>
						</tr>
					   <tr></tr>
					</table>
				</div>
				<div>
					<h2>登录--验证码查询</h2>
					<table  align="center">
						<tr>
							<td>
								<form action="inf/clnregLog/requestLogin" method="post">
									用户工号: <input type="text" name="CUST_CODE" />
									<input type="submit" value="查询一下" />
								</form>
							</td>
						</tr>
					   <tr></tr>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>
