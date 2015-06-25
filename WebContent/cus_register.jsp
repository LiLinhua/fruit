<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/cus_register.css" rel="stylesheet" />
</head>
<body>
	<div class="cus_register">
	<div id="successTips">
	<%
		String flag = request.getParameter("flag");
		if(flag != null && flag.equals("1"))
		{
	%>
			<h1>恭喜恭喜，您已经成功注册！<a href="cus_login.jsp">登录</a></h1>
	<%
		}else if((flag != null && flag.equals("0")) || (flag != null && flag.equals("2")))
		{
	%>
			<h1>I'm very very sorry! Fail to register! Try again,please!</h1>
	<%
		}
	%>
	</div>
			<div class="cus_register_in">
				<h1>客户端注册</h1>
				<form action="Servlet_register_cus" method="post" onsubmit="return checkForm()">
					<ul>
						<li class="text">用户名</li>
						<li><input type="text" name="cus_name" id="cus_name"><span id="nameError" class="errorTips">*请输入用户名</span></li>
						<li class="text">密码</li>
						<li><input type="password" name="cus_password" id="cus_password"><span id="passwordError" class="errorTips">*6-20数字字母</span></li>
						<li class="text">确认密码</li>
						<li><input type="password" name="cus_password1" id="cus_password1"><span id="password1Error" class="errorTips">*再次确认密码</span></li>
						<li class="text">性别</li>
						<li><input type="radio" name="cus_gender" value="男" id="gender" checked="checked">男<input type="radio" name="cus_gender" id="gender" value="女">女</li>
						<li class="text">手机号码</li>
						<li><input type="text" name="cus_phone" id="cus_phone"><span id="phoneError" class="errorTips">*11位手机号码</span></li>
						<li class="text">邮箱</li>
						<li><input type="text" name="cus_mail" id="cus_mail"><span id="mailError" class="errorTips">*用于找回密码</span></li>
						<li><input type="submit" id="submit" value="注册"></li>
						<li><a href="index.jsp" id="goShoping"><img src="images/cart.jpg"><span id="span">先逛逛</span></a><a href="cus_login.jsp" id="goLogin"><img src="images/us1.png"><span id="span">去登录</span></a></li>
					</ul>
				</form>
			</div>
		</div>
</body>
<script src="js/cus_register.js" type="text/javascript"></script>
<script src="js/cus_register_ajax.js" type="text/javascript"></script>
</html>