<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page 
import="javax.servlet.http.HttpServlet,
javax.servlet.http.HttpServletRequest,
javax.servlet.http.HttpServletResponse,
javax.servlet.http.HttpSession" %> 
    <%
    String cus_name = null;
 
    String flag = request.getParameter("flag");

	cus_name=(String)session.getAttribute("cus_name");
	
    if(cus_name != null )
    {
    	response.sendRedirect("index.jsp");
    	return;
    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/cus_login.css" rel="stylesheet" type="text/css" />
<link href="css/head.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<div id="p">
	<p>客户端登陆</p>
</div>
<form action="Servlet_login_cus" method="post" onsubmit="return checkLogin() && checkCodeAjaxW(this.value)">
	<div id="login">
	<div id="loginIn">
			<p>用户名：<input type="text" name="cus_name" class="input" id="username" value="" onblur="checkName()" ></p>
		   	<div id="nameError">
		   	<% 
		   		if(flag != null && flag.equals ("0") )
		   		{
		   	%>
		   	<font color="red">用户名不存在</font>
		   	<%
		   		}
		   	%>
		   	</div>
		    密&nbsp;&nbsp;码：<input type="password" class="input" placeholder="6-20位字母数字" name="cus_password" id="pwd" value=""><br>
		    <div id="pwdError">
		    <% 
		   		if(flag != null && flag.equals("1"))
		   		{
		   	%>
		   		<font color="red">密码错误</font>
		   	<%
		   		}
		   	%>
		   	</div><br>
		   	<!-- 
		 验证码：<input type="text" placeholder="请输入验证码" class="input" name="checkCode" id="checkCode">
		 	<div id="checkCodeError">
		 	</div>
		 <a href="javascript:void(0);" id="changeCode">
		 <img src="Servlet_get_code?method=getCode" id="checkCodeImg"  >
		 看不清，换一张
		 </a>
		  --><br>
		     &nbsp; &nbsp;&nbsp;<input type="submit" name="submit" value="登陆" class="loginSubmit">
		     &nbsp;&nbsp;<a href="#">忘记密码？</a><a href="cus_register.jsp">注册</a>
	</div>
	</div>
</form>
<jsp:include page="foot.jsp"/> 
<script type="text/javascript" src="js/cus_login.js" charset="utf-8"></script>
<!--  <script type="text/javascript" src="js/cus_checkCode_ajax.js" charset="utf-8"></script>
-->
</body>
</html>