<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fruit.dao.factory.*" %>
<%
if(session.getAttribute("cus_name") != null && !session.getAttribute("cus_name").equals(""))
{
	String changeFlag = null;
	changeFlag = request.getParameter("changeFlag");
	
	String cus_name = null;
	String old_address = null;
	cus_name = request.getParameter("cus_name");
	if(cus_name != null && !cus_name.equals(""))
	{
		old_address = Factory_cus_info.getCusInfoByName(cus_name).getCus_address();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改您的配送地址</title>
<link href="css/cus_register.css" rel="stylesheet" />
</head>
<body>
	<body>
		<div class="cus_register">
			<div id="changeFlag"></div>
			<div class="cus_register_in">
				<h2>配送地址修改</h2>
					<p id="p">请输入新的配送地址</p>
					<input type="text" id="newAddress" name="cus_name" required="required" value="<%=old_address %>"/>
					<input type="button" id="change_submit" name="change_submit" value="确定修改" />
					<input type="button" id="back" name="cback" value="返回" />
			</div>
		</div>
	</body>
</body>
<script src="js/changeAddress_ajax.js" type="text/javascript"></script>
</html>
<%
	}else
	{
		response.sendRedirect("cus_login.jsp");
	}
%>