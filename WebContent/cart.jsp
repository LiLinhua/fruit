<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="javax.servlet.http.HttpServlet,
javax.servlet.http.HttpServletRequest,
javax.servlet.http.HttpServletResponse,
javax.servlet.http.HttpSession" %> 
<%@page import="fruit.dao.factory.*,fruit.dao.proxy.*,fruit.vo.*,java.util.List,java.util.Iterator"%> 
<%
	String cus_name = null;
    String addCartFlag = null;
    
	cus_name = (String)session.getAttribute("cus_name");
	addCartFlag = request.getParameter("addCartFlag");
	
	if(cus_name == null || cus_name.equals(""))
	{
		response.sendRedirect("cus_login.jsp");
		return;
	}else
	{
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8">
		<title>您的购物车</title>
		<link rel="shortcut icon" href="images/search.jpg" />
		<link href="css/head.css" rel="stylesheet" type="text/css" />
		<link href="css/cart.css" rel="stylesheet" type="text/css" />
		<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<!--头部内容开始-->
	<jsp:include page="head.jsp"/> 
<!--头部内容结束-->
	
	<!--中部内容开始-->
	
	<div id="cart_center" class="cart_center">
	<%
		if(addCartFlag != null && addCartFlag.equals("true"))
		{
	%>
		<p id="add_cart_tips">
			商品添加成功！<a href="show.jsp?kind_id=1" class="cart_continue_shopping">继续购物</a><a href="myOrderItem.jsp" class="cart_continue_shopping">我的订单</a>
		</p>
	<% 
		}else if(addCartFlag != null && addCartFlag.equals("false"))
		{
	%>
		<p id="add_cart_tips">
			商品添加失败！<a href="myOrderItem.jsp" class="cart_continue_shopping">我的订单</a>
		</p>
	<%
		}else if(addCartFlag != null && addCartFlag.equals("deleteTrue"))
		{
	%>
		<p id="add_cart_tips">
			商品删除成功！<a href="show.jsp?kind_id=1" class="cart_continue_shopping">继续购物</a><a href="myOrderItem.jsp" class="cart_continue_shopping">我的订单</a>
		</p>
	<%
		}else if(addCartFlag != null && addCartFlag.equals("deleteFalse"))
		{
	%>
		<p id="add_cart_tips">
			商品删除失败！<a href="myOrderItem.jsp" class="cart_continue_shopping">我的订单</a>
		</p>
	<%
		}else if(addCartFlag != null && addCartFlag.equals("all"))
		{
	%>
		<p id="add_cart_tips">
			商品添加成功！<a href="show.jsp?kind_id=1" class="cart_continue_shopping">继续购物</a><a href="myOrderItem.jsp" class="cart_continue_shopping">我的订单</a>
		</p>
	<%
		}else if(addCartFlag != null && addCartFlag.equals("none"))
		{
	%>
	<p id="add_cart_tips">
			商品添加失败！<a href="myOrderItem.jsp" class="cart_continue_shopping">我的订单</a>
	</p>
	<%
		}else if(addCartFlag != null && addCartFlag.equals("part"))
		{
	%>
	<p id="add_cart_tips">
			商品添加部分成功！<a href="show.jsp?kind_id=1" class="cart_continue_shopping">继续购物</a><a href="myOrderItem.jsp" class="cart_continue_shopping">我的订单</a>
	</p>
	<%
		}
	%>
		<div id="cart_details" class="cart_details">
			<h3 id="cart_list_title" class="cart_list_title">
				购物车商品如下
			</h3>
			<ul>
				<li id="cart_list_title_part">
					<ul>
						<li>购买</li>
						<li id="cart_goods_brief">商品</li>
						<li>价格</li>
						<li>优惠</li>
						<li>库存量</li>
						<li>数量</li>
						<li id="cart_buy_do">操作</li>
					</ul>
				</li>
				<%
								List<Vo_cartItem_info> cartItemList = null;
								cartItemList = Factory_cartItem_info.getCartItemByCusName(cus_name);
								Iterator<Vo_cartItem_info> iter = cartItemList.iterator();
								while(iter.hasNext())
								{
									Vo_cartItem_info voCartItemInfo = iter.next();	
				%>
				<li>
					<ul>
						<input type="hidden" id="goods_each_price" name="goods_each_price" value="<%=voCartItemInfo.getGoods_each_price()%>">
						<li><input type="checkbox" name="goods_id_str" value="<%=voCartItemInfo.getGoods_id()%>"></li>
						<li id="cart_goods_brief"><img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(voCartItemInfo.getGoods_id()).getGoods_picture()%>"><p><%=voCartItemInfo.getGoods_name()%></p></li>
						<li><p class="cart_price"><%=voCartItemInfo.getGoods_each_price()%></p></li>
						<li class="cart_list_font">无</li>
						<li><span class="cart_list_font"><%=Factory_goods_info.getGoodsInfoByGoodsId(voCartItemInfo.getGoods_id()).getGoods_stock()%></span></li>
						<li id="cart_buy_num"><span class="cart_buy_num"><input type="number" min="1" step="1" max="1000" name="num" id="num" class="num" value="<%=voCartItemInfo.getGoods_quantity()%>" required="required"></span><span class="goods_unit">千克</span></li>
						<li><a href="Servlet_doCart_ajax?doFlag=deleteCartItem&cartItem_id=<%=voCartItemInfo.getCartItem_id() %>" class="cart_list_font">删除</a></li>
					</ul>
				</li>
				<%
								}
				%>
				
				<li id="little_count">
					<p class="cart_small_count_info">小计（ 已选<span class="cart_goods_buy_total_num" id="cart_goods_buy_total_num">0</span>件商品 ）：￥<span id="cart_goods_buy_total_price" class="cart_goods_buy_total_price">0</span></p>
					
						<input type="button" class="cart_buy_a" id="cart_buy_a" value="提交订单"> 
						<a href="#" id="hiddenA"></a>
					
				</li>
			</ul>
		</div>
		
		<div class="cart_others">
			<ul>
				<li>
					<a href="details.jsp?goods_id=<%=Factory_goods_info.getGoodsInfoByGoodsId(24).getGoods_id() %>">
						<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(24).getGoods_picture() %>" />
					</a>
					<div class="cart_hidden_block">
						<div class="title"><%=Factory_goods_info.getGoodsInfoByGoodsId(24).getGoods_brief() %></div>
						<div class="price"><%=Factory_goods_info.getGoodsInfoByGoodsId(24).getGoods_price() %></div>
						<div class="danwei">元/千克</div>
					</div>
				</li>
				<li>
					<a href="details.jsp?goods_id=<%=Factory_goods_info.getGoodsInfoByGoodsId(4).getGoods_id() %>">
						<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(4).getGoods_picture() %>" />
					</a>
					<div class="cart_hidden_block">
						<div class="title"><%=Factory_goods_info.getGoodsInfoByGoodsId(4).getGoods_brief() %></div>
						<div class="price"><%=Factory_goods_info.getGoodsInfoByGoodsId(4).getGoods_price() %></div>
						<div class="danwei">元/千克</div>
					</div>
				</li>
				<li>
					<a href="details.jsp?goods_id=<%=Factory_goods_info.getGoodsInfoByGoodsId(44).getGoods_id() %>">
						<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(44).getGoods_picture() %>" />
					</a>
					<div class="cart_hidden_block">
						<div class="title"><%=Factory_goods_info.getGoodsInfoByGoodsId(44).getGoods_brief() %></div>
						<div class="price"><%=Factory_goods_info.getGoodsInfoByGoodsId(44).getGoods_price() %></div>
						<div class="danwei">元/千克</div>
					</div>
				</li>
				<li>
					<a href="details.jsp?goods_id=<%=Factory_goods_info.getGoodsInfoByGoodsId(54).getGoods_id() %>">
						<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(54).getGoods_picture() %>" />
					</a>
					<div class="cart_hidden_block">
						<div class="title"><%=Factory_goods_info.getGoodsInfoByGoodsId(54).getGoods_brief() %></div>
						<div class="price"><%=Factory_goods_info.getGoodsInfoByGoodsId(54).getGoods_price() %></div>
						<div class="danwei">元/千克</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
	
	<!--中部内容结束-->
	
	
	
	<jsp:include page="foot.jsp"/> 
	<script src="js/cart.js" type="text/javascript">	
	</script>
</body>
</html>
<%
	}
%>