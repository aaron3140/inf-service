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
								<form action="inf/password/requestpassword" method="post">
									原始密码: <input type="text" name="password" />
									E卡卡号: <input type="text" name="ecardno" />
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
