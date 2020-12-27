<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<title></title>
</head>
<body>
<form id="userfrom" action="/index" method="post">
用户名：<input type="text" id="userid" name="userid" />
密码：<input type="password" id="pwd" name="pwd" />
<input type="button" value="登录" onclick="login()"/>
<p style="color: red;">${userinfo.userid  }</p>
</form>
</body>

<script type="text/javascript">
function login(){
	var userid = document.getElementById("userid").value;
	var pwd = document.getElementById("pwd").value;
	if(!userid){
	$("p").html("用户名不能为空");
	return false;
	}
	if(!pwd){
	$("p").html("密码不能为空");
	return false;
	}
	document.getElementById("userfrom").submit();
}
</script>
</html>

