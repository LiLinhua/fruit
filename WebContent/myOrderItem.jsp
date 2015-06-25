<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="fruit.dao.factory.*,fruit.dao.proxy.*,fruit.vo.*,java.util.List,java.util.Iterator"%>
 <%
 	String cus_name = null;
 	cus_name =(String)session.getAttribute("cus_name");
	if(cus_name != null && !cus_name.equals(""))
	{
		
		
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>您的订单</title>
<link href="css/ensureBuyInfo.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="cart_center" class="cart_center">
		<div id="cart_details" class="cart_details">
		
				<div id="resultTips"></div>
			<h3 id="cart_list_title" class="cart_list_title">
			您的订单如下
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
						<li>订单状态</li>
					</ul>
				</li>
				<%
								List<Vo_orderItem_info> vo_orderItem_info_list = null;
								vo_orderItem_info_list = Factory_orderItem_info.getOrderItemByCusName(cus_name);
								Iterator<Vo_orderItem_info> iter = vo_orderItem_info_list.iterator();
								while(iter.hasNext())
								{
									Vo_orderItem_info vo_orderItem_info = iter.next();	
				%>
				<li id="goods_details_info">
					<ul>
						<li id="cart_goods_brief" class="cart_goods_brief"><img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(vo_orderItem_info.getGoods_id()).getGoods_picture() %>"><p><%=Factory_goods_info.getGoodsInfoByGoodsId(vo_orderItem_info.getGoods_id()).getGoods_name() %></p></li>
						<li><p class="cart_price cart_list_font" id="cart_price" value="<%=Factory_goods_info.getGoodsInfoByGoodsId(vo_orderItem_info.getGoods_id()).getGoods_price() %>"><%=Factory_goods_info.getGoodsInfoByGoodsId(vo_orderItem_info.getGoods_id()).getGoods_price() %></p></li>
						<li><p class="cart_list_font" id="buy_num"><%=vo_orderItem_info.getGoods_quantity() %></p></li>
						<li><p class="cart_list_font" id="total_price"><span id="goods_total_price_span" value="<%=vo_orderItem_info.getGoods_total_price() %>"><%=vo_orderItem_info.getGoods_total_price() %></span></p></li>
						<li id="cus_info" class="cus_info"><p class="cart_list_font"><%=vo_orderItem_info.getCus_name() %><br /><%=Factory_cus_info.getCusInfoByName(cus_name).getCus_phone() %></p></li>
						<li id="cus_address" class="cus_address cart_list_font"><p ><%=Factory_cus_info.getCusInfoByName(cus_name).getCus_address() %></p></li>
						<li class="cart_list_font"><p ><%=vo_orderItem_info.getOrderItem_state() %></p></li>
						
					</ul>
				</li>
				<%
						}
				%>
				<li id="little_count">
					<a href="show.jsp?kind_id=1">返回首页</a> 
				</li>
			</ul>
		</div>
</body>
</html>
<%
	}else
	{
		response.sendRedirect("cus_login.jsp");
	}
%>