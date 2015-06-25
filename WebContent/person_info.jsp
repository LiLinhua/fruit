<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fruit.dao.factory.*" %>
<%
if(session.getAttribute("cus_name") != null && !session.getAttribute("cus_name").equals(""))
{
		
		String cus_name = null;
		String changeFlag = null;
		cus_name = request.getParameter("cus_name");
		changeFlag = request.getParameter("changeFlag");
		if(cus_name != null && !cus_name.equals(""))
		{
			cus_name = new String(cus_name.getBytes("ISO-8859-1"),"UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>您的信息</title>
<link href="css/personInfo.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="person_info">
			<div class="person_info_in">
				<% 
					if(changeFlag != null && changeFlag.equals("true"))
					{
				%>
				<h1 style="color:red">信息修改成功</h1>
				<%
					}
				%>
				<h1>您的信息如下</h1>
					<ul>
						<li class="text">用户名</li>
						<li class="person_value"><%=Factory_cus_info.getCusInfoByName(cus_name).getCus_name()%></li>
						<li class="text">性别</li>
						<li class="person_value"><%=Factory_cus_info.getCusInfoByName(cus_name).getCus_gender()%></li>
						<li class="text">手机号码</li>
						<li class="person_value"><%=Factory_cus_info.getCusInfoByName(cus_name).getCus_phone()%></li>
						<li class="text">邮箱</li>
						<li class="person_value"><%=Factory_cus_info.getCusInfoByName(cus_name).getCus_mail()%></li>
						<li class="text">邮政编码</li>
						<li class="person_value"><%=Factory_cus_info.getCusInfoByName(cus_name).getCus_postcode()%></li>
						<li class="text">送货地址</li>
						<li class="person_value"><%=Factory_cus_info.getCusInfoByName(cus_name).getCus_address()%></li>
						<li class="text">注册时间</li>
						<li class="person_value"><%=Factory_cus_info.getCusInfoByName(cus_name).getCus_register_time()%></li>
						<li class="person_do"><a href="updatePersonInfo.jsp">修改以上资料</a><a href="#">修改密码</a></li>
					</ul>
			</div>
		</div>
</body>
</html>
<%
		}else
		{
			response.sendRedirect("cus_login.jsp");
		}
	}else
	{
		response.sendRedirect("cus_login.jsp");
	}
%>