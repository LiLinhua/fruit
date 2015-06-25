<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="fruit.dao.factory.*"%>
<%
	if(session.getAttribute("cus_name") != null && !session.getAttribute("cus_name").equals(""))
	{
		String cus_name = null;
		String goods_id = null;
		String goods_name = null;
		String goods_each_price = null;
		String goods_quantity = null;
		String goods_total_price = null;
		String changeInfoFlag = null;
		
		cus_name = (String)session.getAttribute("cus_name");
		goods_id = request.getParameter("goods_id");
		goods_name = request.getParameter("goods_name");
		goods_each_price = request.getParameter("goods_each_price");
		goods_quantity = request.getParameter("goods_quantity");
		goods_total_price = request.getParameter("goods_total_price");
		changeInfoFlag = request.getParameter("changeInfoFlag");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请确认您的信息</title>
<link href="css/ensureBuyInfo.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="cart_center" class="cart_center">
		<div id="cart_details" class="cart_details">
		
			<div id="resultTips"></div>
			<h3 id="cart_list_title" class="cart_list_title">
				请确认您的购买信息
			</h3>
			<ul>
				<li id="cart_list_title_part">
					<ul>
						<li id="cart_goods_brief" class="cart_goods_brief">商品</li>
						<li>单价</li>
						<li>数量</li>
						<li>实付款</li>
						<li id="cus_info" class="cus_info">收货人信息</li>
						<li id="cus_address" class="cus_address">配送地址</li>
					</ul>
				</li>
				<li id="goods_details_info">
					<ul>
						<input type="hidden" id="goods_id" value="<%=goods_id %>">
						<input type="hidden" id="goods_each_price" value="<%=goods_each_price %>">
						<li id="cart_goods_brief" class="cart_goods_brief"><img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(Integer.parseInt(goods_id)).getGoods_picture() %>"><p><%=goods_name %></p></li>
						<li><p class="cart_price cart_list_font" id="cart_price"><%=goods_each_price %></p></li>
						<li><p class="cart_list_font" id="buy_num"><input name="goods_quantity" type="number" value="<%=goods_quantity %>" min="1" max="100000" step="1" id="buy_num_input"></p></li>
						<li><p class="cart_list_font" id="total_price"><span id="goods_total_price_span" value="<%=goods_total_price %>"><%=goods_total_price %></span></p></li>
						<li id="cus_info" class="cus_info"><p class="cart_list_font"><%=cus_name %><br /><%=Factory_cus_info.getCusInfoByName(cus_name).getCus_phone() %></p></li>
						<li id="cus_address" class="cus_address cart_list_font"><p ><%=Factory_cus_info.getCusInfoByName(cus_name).getCus_address() %></p></li>
						<li id="cus_address_do" class="cart_list_font"><a href="changeAddress.jsp?cus_name=<%=cus_name %>">修改地址</a></li>
					</ul>
				</li>
				<li id="little_count">
					<input type="button" id="ensureBuy" value="确认购买"> 
				</li>
			</ul>
		</div>
</body>
<script src="js/ensureBuyInfo_ajax.js" type="text/javascript">		
	</script>
</html>
<%
	}else
	{
		response.sendRedirect("cus_login.jsp");
	}
%>