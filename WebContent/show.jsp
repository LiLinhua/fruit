<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fruit.dao.factory.*,fruit.dao.proxy.*,fruit.vo.*,java.util.List,java.util.Iterator"%> 
<%
	String kind_id = null;
	String keyword = null;
	kind_id = request.getParameter("kind_id");
	keyword = request.getParameter("keyword");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品集锦</title>
		<link rel="shortcut icon" href="images/search.jpg" />
		<link href="css/head.css" rel="stylesheet" type="text/css" />
		<link href="css/show.css" rel="stylesheet" type="text/css" />
		<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="head.jsp"/> 
<!--中部内容-->
		<div id="show_center">
		<div id="sort_div">
		</div>
		
		<div id="goods_show_div" class="goods_show_div">
		<ul>
		<%
						
								List<Vo_goods_info> goodsInfoList = null;
							if(kind_id != null)
							{
								if(Integer.parseInt(kind_id) < 8)
								{
									goodsInfoList = Factory_goods_info.getGoodsInfoByFatherKindId(Integer.parseInt(kind_id));
								}
								else if(Integer.parseInt(kind_id) > 7)
								{
									goodsInfoList = Factory_goods_info.getGoodsInfoByKindId(Integer.parseInt(kind_id));
								}
							}else if(keyword != null)
							{
								keyword = new String(keyword.getBytes("ISO-8859-1"),"UTF-8");
								goodsInfoList = Factory_goods_info.getValueByGoodsNameGoodsBrief(keyword);
							}
								Iterator<Vo_goods_info> iter = goodsInfoList.iterator();
								while(iter.hasNext())
								{
									Vo_goods_info voGoodsInfo= iter.next();	
		%>
		<li>
				<a href="details.jsp?goods_id=<%=voGoodsInfo.getGoods_id() %>">
				<div id="show_row1_1" class="show_style">
					<img src="<%=voGoodsInfo.getGoods_picture() %>" id="show_img" class="show_img"/>
					<div id="hidden_block" class="hidden_block">
						<div class="title"><%=voGoodsInfo.getGoods_brief() %></div>
						<div class="price"><%=voGoodsInfo.getGoods_price() %></div>
						<div class="danwei">元/千克</div>
					</div>
				</div>
				</a>
				</li>
				<%
								}
						
				%>
			</ul>
			<div id="paging">
				<ul>
					<li><img src="images/last.jpg" alt="上一页"></li>
					<li><img src="images/next.jpg" alt="下一页"></li>
					<li><img src="images/go.png" alt="跳转"></li>
					<li><form action="#" method="get"><input type="number" min="1" max="1000" step="1"></form></li>
				</ul>
			</div>
		</div>
		</div>
		
		
		<!--中部内容结束-->

<jsp:include page="foot.jsp"/> 
</body>
</html>
