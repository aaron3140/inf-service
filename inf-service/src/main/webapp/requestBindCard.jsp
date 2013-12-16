<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>前置INF工具箱</title>
	<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/inf.css" />
			<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.1.min.js"></script>
			
			<script type="text/javascript">

		$(document).ready(function() {
		      var saveData={"loginName":"test","name":"gz"};  
				$.ajax({
					   type: "get",
					   url: "http://localhost:8080/inf-util/inf/shortcutTrader",
					   crossDomain : ture,
				//	   dataType:"json",      
			     //       contentType:"application/json",         
					   data: JSON.stringify(saveData), 
					   success: function(msg){
					    // alert( "Data Saved: " + msg );
					   }
					});
		});
	</script>
			
	</head>
	<body class="html">
		<div id="wrapper">
			<div id="maincontent">
				<div>
					<h2>1使用说明:</h2>
					<p>操作细则。</p>
				</div>
				<div>
					<h2>在线注册--绑卡查询</h2>
					<table  align="center">
						<tr>
							<td>
								<form action="inf/bindCard/requestBindCard" method="post">
									客户编码: <input type="text" name="CUST_CODE" />
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
