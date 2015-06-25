<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fruit.dao.factory.*" %>
<%
	if(session.getAttribute("cus_name") != null && !session.getAttribute("cus_name").equals(""))
	{
		String cus_name = "checked=''";
		String changeFlag = "checked=''";
		changeFlag = request.getParameter("changeFlag");
		cus_name = (String)session.getAttribute("cus_name");
		String gender1 = null;
		String gender2 = null;
		if(cus_name != null && Factory_cus_info.getCusInfoByName(cus_name).getCus_gender().equals("男"))
		{
			gender1 = "checked='checked'";
		}
		else
		{
			gender2 = "checked='checked'";
		}
				
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改信息</title>
<link href="css/updatePersonInfo.css" rel="stylesheet" />
</head>
<body>
		<div class="person_info">
			<div class="person_info_in">
			<% 
					if(changeFlag != null && changeFlag.equals("false"))
					{
				%>
				<h1 style="color:red">I'm very sorry!信息修改失败</h1>
				<%
					}
				%>
				<h1>您的信息如下</h1>
				<form action="Servlet_updatePersonInfo?flag=changeAll" method="post" onsubmit="return checkForm()">
					<ul>
						<input type="hidden" name="cus_old_name" value="<%=session.getAttribute("cus_name")%>"/>
						<li class="text">用户名</li>
						<li class="person_value"><input type="text" id="cus_name" name="cus_name" value="<%=Factory_cus_info.getCusInfoByName(cus_name).getCus_name()%>"/><span id="nameError"></span></li>
						<li class="text">性别</li>
						<li class="person_value"><input type="radio" id="cus_gender" name="cus_gender" value="男" <%=gender1 %>/><span>男</span><input type="radio" id="cus_gender" name="cus_gender" value="女" <%=gender2 %>/><span>女</span></li>
						<li class="text">手机号码</li>
						<li class="person_value"><input type="text" id="cus_phone" name="cus_phone" value="<%=Factory_cus_info.getCusInfoByName(cus_name).getCus_phone()%>"/><span id="phoneError"></span></li>
						<li class="text">邮箱</li>
						<li class="person_value"><input type="text" id="cus_mail" name="cus_mail" value="<%=Factory_cus_info.getCusInfoByName(cus_name).getCus_mail()%>"/><span id="mailError"></span></li>
						<li class="text">邮政编码</li>
						<li class="person_value"><input type="text" id="cus_postcode" name="cus_postcode" value="<%=Factory_cus_info.getCusInfoByName(cus_name).getCus_postcode()%>"/><span id="postcodeError"></span></li>
						<li class="text">送货地址</li>
						<li class="person_value"><input type="text" id="cus_address" name="cus_address" value="<%=Factory_cus_info.getCusInfoByName(cus_name).getCus_address()%>"/><span id="addressError"></span></li>
						<li class="person_do"><input type="submit" value="提交修改" id="personDoSubmit"><input type="button" value="返回" class="personDoInput"  id="updatePersonInfoBack"></li>
					</ul>
				</form>
			</div>
		</div>
	</body>
	<script src="js/updatePersonInfo.js" language="JavaScript" type="text/javascript">
	</script>
	<script src="js/updatePersonInfo_ajax.js" language="JavaScript" type="text/javascript">
	</script>
</html>
<%
	}else
	{
		response.sendRedirect("cus_login.jsp");
	}
%>