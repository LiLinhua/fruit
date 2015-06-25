<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fruit.dao.factory.*,fruit.dao.proxy.*,fruit.vo.*,java.util.List,java.util.Iterator"%> 
<%
	String goods_info = null;
	goods_info = request.getParameter("goods_id");
	if(goods_info != null && !goods_info.equals(""))
	{
		int goodsInfo = Integer.parseInt(goods_info);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>细节页面</title>
		<link rel="shortcut icon" href="../images/search.jpg" />
		<link href="css/details.css" rel="stylesheet" type="text/css" />
		<link href="css/head.css" rel="stylesheet" type="text/css" />
		<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="head.jsp"/> 
<!--中部内容-->
		<div id="details_center">
			
			<div id="details">
				<div id="details_rol_1" class="details_show2">
					<div id="comments_block" class="details_rol_11">
						<h2 id="comments_title" class="details_rol_title">商品评价</h2>
						<div id="comments_details" class="details_rol_details">
							<ul>
							<%
								List<Vo_comment_info> commentInfoList = null;
								commentInfoList = Factory_comment_info.getGoodsCommentByGoodsId(goodsInfo);
								Iterator<Vo_comment_info> iter = commentInfoList.iterator();
								while(iter.hasNext())
								{
									Vo_comment_info voCommentInfo= iter.next();	
							%>
								<li>
									
									<p class="cus_info">
										<span class="cus_name"><%=voCommentInfo.getCus_name()%></span>
										<span class="comments_time"><%=voCommentInfo.getComment_time()%></span>
										<span class="goods_score"><%=voCommentInfo.getGoods_score()%>分</span>
									</p>
									<p class="comments_content">
									<%=voCommentInfo.getComment_content()%>
									</p>
								</li>
							<%
								}
							%>
								<li>
									<a href="#">首页</a>
									<a href="#">上一页</a>
									<a href="#">下一页</a>
								</li>
							</ul>
						</div>
					</div>
					<div id="buy_do" class="details_rol_12">
						<div class="buy_do_goods_brief">
							<h3><%=Factory_goods_info.getGoodsInfoByGoodsId(goodsInfo).getGoods_name()%></h3>
							<p><%=Factory_goods_info.getGoodsInfoByGoodsId(goodsInfo).getGoods_brief()%></p>
						</div>
						<div id="goods_buy_info" class="goods_buy_info">
							<form action="ensureBuyInfo.jsp" method="post" onsubmit="return checkBuyNum()" id="myForm">
								
								<!--hidden元素保存商品ＩＤ-->
								<input type="hidden" id="goods_id" name="goods_id" value="<%=goods_info%>" />
								
								<!--hidden元素保存商品名称-->
								<input type="hidden" name="goods_name" value="<%=Factory_goods_info.getGoodsInfoByGoodsId(goodsInfo).getGoods_name()%>" />
								
								<!--hidden元素保存商品单价-->
								<input type="hidden" name="goods_each_price" id="goodsEachPrice" value="<%=Factory_goods_info.getGoodsInfoByGoodsId(goodsInfo).getGoods_price()%>" />
								
								<!--hidden元素保存商品总价-->
								<input type="hidden" name="goods_total_price" id="goods_total_price" value="" />
								
							<ul>
								<li><span class="buy_tips">价格</span>
										<input type="hidden" name="goods_price" value="<%=Factory_goods_info.getGoodsInfoByGoodsId(goodsInfo).getGoods_price()%>">
										<em class="yen">￥</em>
										<span class="goods_each_price" id="goods_each_price"><%=Factory_goods_info.getGoodsInfoByGoodsId(goodsInfo).getGoods_price()%></span>
										<em class="unit">/千克</em>
									
								</li>
								<li>
									<span class="buy_tips">库存量</span><span class="goods_store goods_each_price"><%=Factory_goods_info.getGoodsInfoByGoodsId(goodsInfo).getGoods_stock()%></span>
								</li>
								<li>
										<span class="buy_tips">月销量</span><span class="sale_num goods_each_price">60</span>
										<span class="buy_tips">累计评价</span><span class="comments_num goods_each_price">600</span>
								</li>
								<li id="goods_buy_num">
									<span class="buy_tips">购买数量</span>
									<input type="number" min="1" step="1" max="1000" value="1" class="buy_num" id="buy_num" name="goods_quantity">
									<span class="unit">千克</span>
									<span id="buy_num_tips"></span>
								</li>
							</ul>
							<%
								if(session.getAttribute("cus_name") != null && !session.getAttribute("cus_name").equals(""))
								{
							%>
							<input type="submit" name="buy" value="购买" class="buy_submit"/>
							
							<input type="button" id="addCart" name="addCart" class="buy_submit" value="加入购物车">
							
							<a href="#" id="hiddenA" target="_self"></a>
							<%
								}else
								{
							%>
							<p id="loginCanBuy">登录可买</p>
							<%
								}
							%>
							</form>
							
						</div>
					</div>
				</div>
				<div id="details_rol_2">
					<div id="big_mirro" class="big_mirro">
						<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(goodsInfo).getGoods_picture()%>" id="details_small_pic">
						<!--<a href="images/roll8.jpg" id="demo" style="position: relative;float: left;">
							<img src="images/roll8.jpg" width="670" height="580" id="details_small_pic">
						    <img src="images/roll8.jpg" width="960" height="720" style="display: none;">
						</a>-->
					</div>
					<div id="zoom_do" class="zoom_do">
						<div id="bofore" class="before_next">
							<img src="images/last.jpg"/>
						</div>
						<ul>
							<li>
								<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(goodsInfo).getGoods_picture()%>" class="zoom_ul_img" onclick="change_img(this.src)"/>
							</li>
							<li>
								<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(goodsInfo).getGoods_picture()%>" class="zoom_ul_img" onclick="change_img(this.src)"/>
							</li>
							<li>
								<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(goodsInfo).getGoods_picture()%>" class="zoom_ul_img" onclick="change_img(this.src)"/>
							</li>
							<li>
								<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(goodsInfo).getGoods_picture()%>" class="zoom_ul_img" onclick="change_img(this.src)"/>
							</li>
						</ul>
						<div id="next" class="before_next">
							<img src="images/next.jpg" id="next"/>
						</div>
					</div>
				</div>
				
				<div id="details_rol_3" class="details_show2 ">
					<div id="goods_describe" class="details_rol_11">
						<h2 id="goods_describe_title" class="details_rol_title">商品详细介绍</h2>
						<div id="goods_describe__details" class="details_rol_details">
							<%=Factory_goods_info.getGoodsInfoByGoodsId(goodsInfo).getGoods_details()%>
						</div>
					</div>
					<div id="after_sale" class="details_rol_12">
						<h2 id="goods_describe_title" class="details_rol_title">商品售后服务</h2>
						<div id="goods_describe__details" class="details_rol_details">
							<%=Factory_goods_info.getGoodsInfoByGoodsId(goodsInfo).getAfter_sail_transform()%>
						</div>
					</div>
				</div>
			</div>
			
			<div id="others">
				<ul>
					<li><a href="Servlet_details?goods_id=<%=Factory_goods_info.getGoodsInfoByGoodsId(23).getGoods_id()%>">
						<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(23).getGoods_picture()%>" />
						<div class="details_others_tips">
							<div class="title"><%=Factory_goods_info.getGoodsInfoByGoodsId(23).getGoods_brief()%></div>
							<div class="price"><%=Factory_goods_info.getGoodsInfoByGoodsId(23).getGoods_price()%></div>
							<div class="danwei">元/千克</div>
						</div>
					</a></li>
					<li><a href="Servlet_details?goods_id=<%=Factory_goods_info.getGoodsInfoByGoodsId(34).getGoods_id()%>">
						<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(34).getGoods_picture()%>" />
						<div class="details_others_tips">
							<div class="title"><%=Factory_goods_info.getGoodsInfoByGoodsId(34).getGoods_brief()%></div>
							<div class="price"><%=Factory_goods_info.getGoodsInfoByGoodsId(34).getGoods_price()%></div>
							<div class="danwei">元/千克</div>
						</div>
					</a></li>
					<li><a href="Servlet_details?goods_id=<%=Factory_goods_info.getGoodsInfoByGoodsId(53).getGoods_id()%>">
						<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(53).getGoods_picture()%>" />
						<div class="details_others_tips">
							<div class="title"><%=Factory_goods_info.getGoodsInfoByGoodsId(53).getGoods_brief()%></div>
							<div class="price"><%=Factory_goods_info.getGoodsInfoByGoodsId(53).getGoods_price()%></div>
							<div class="danwei">元/千克</div>
						</div>
					</a></li>
					<li><a href="Servlet_details?goods_id=<%=Factory_goods_info.getGoodsInfoByGoodsId(64).getGoods_id()%>">
						<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(64).getGoods_picture()%>" />
						<div class="details_others_tips">
							<div class="title"><%=Factory_goods_info.getGoodsInfoByGoodsId(64).getGoods_brief()%></div>
							<div class="price"><%=Factory_goods_info.getGoodsInfoByGoodsId(64).getGoods_price()%></div>
							<div class="danwei">元/千克</div>
						</div>
					</a></li>
				</ul>
			</div>
		</div>
		<!--中部内容结束-->

<jsp:include page="foot.jsp"/> 
<script src="js/details_ajax.js" type="text/javascript">		
</script>
</body>
</html>
<%
	}
%>