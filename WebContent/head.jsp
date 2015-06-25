<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="fruit.dao.factory.*,fruit.dao.proxy.*,fruit.vo.*"%> 
<!--头部内容开始-->
	
	<div id="head" class="head container">
		
		<div id="head_head" class="head_normal_font col-xs-12">
			
			<div id="head_head_1" class="head_head_div">
				<p>我们的追求是：欢迎再来！</p>
				<p id="welcomeYou">欢迎您 
							<%
							if(session.getAttribute("cus_name") != null && session.getAttribute("cus_name") != "")
							{
								String cus_name = (String)session.getAttribute("cus_name");
								out.println(cus_name);
							}
							%>
			</p>
			</div>
			
			<div id="head_head_2" class="head_head_div">
				
					<ul>
						<%
							if(session.getAttribute("cus_name") != null && session.getAttribute("cus_name") != "")
							{
						%>
						<li><a href="Servlet_out?do=out"><img src="" id="out_img">退出</a></li>
						<li><a href="person_info.jsp?cus_name=<%=session.getAttribute("cus_name")%>" target="_self">个人信息</a></li>
						<li><a href="cart.jsp" target="_self">购物车</a></li>
						<li><a href="myOrderItem.jsp" target="_self">我的订单</a></li>
						<%
							}
						%>
						
						<li><a href="show.jsp?kind_id=1">首页</a></li>
						<%
							if(session.getAttribute("cus_name") == null || session.getAttribute("cus_name") == "")
							{
						%>
						<li><a href="cus_login.jsp">登录</a></li>
						<li><a href="cus_register.jsp">注册</a></li>	
						<%
							}
						%>
						
					</ul>
					
				
			</div>
			
		</div>
		
		<div id="head_bottom" class="nav_font">
			<div id="head_bottom_1" class="col-xs-12">
				<h1>鲜果屋</h1>
			</div>
			<div id="search">
			<form action="show.jsp" method="get" id="searchForm">
				<input type="text" id="search" class="search" name="keyword" placeholder="请输入宝贝名称"/>
				<img src="images/search.jpg" onclick="submitToShow()"/>
			</form>
		</div>
			<div id="head_bottom_2" class="col-xs-12">
				<ul>
					<li>
						<a href="show.jsp?kind_id=1" class="kind" id="kind1">浆果类</a>
						<div id="nav_1" class="nav_div">
							<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(67).getGoods_picture()%>" />
							<ul>
								<li><a href="show.jsp?kind_id=8">山莓</a><a href="show.jsp?kind_id=9">蓝莓</a></li>
								<li><a href="show.jsp?kind_id=10">黑莓</a><a href="show.jsp?kind_id=11">桑葚</a></li>
								<li><a href="show.jsp?kind_id=12">红提</a><a href="show.jsp?kind_id=13">青提</a></li>
								<li><a href="show.jsp?kind_id=14">水晶葡萄</a></li>
								<li><a href="show.jsp?kind_id=15">马奶子</a></li>
							</ul>
						</div>
					</li>
					<li>
						<a href="show.jsp?kind_id=2" class="kind" id="kind2">核果类</a>
						<div id="nav_2" class="nav_div">
							<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(14).getGoods_picture()%>" />
							<ul>
								<li><a href="show.jsp?kind_id=16">樱桃</a><a href="show.jsp?kind_id=17">李子</a></li>
								<li><a href="show.jsp?kind_id=18">乌梅</a><a href="show.jsp?kind_id=19">桃子</a></li>
								<li><a href="show.jsp?kind_id=20">梅子</a><a href="show.jsp?kind_id=21">杨梅</a></li>
								<li><a href="show.jsp?kind_id=22">荔枝</a><a href="show.jsp?kind_id=23">龙眼</a></li>
								<li><a href="show.jsp?kind_id=24">槟榔</a><a href="show.jsp?kind_id=25">大枣</a></li>
				
							</ul>
						</div>
					</li>
					<li>
						<a href="show.jsp?kind_id=3" class="kind" id="kind3">坚果类</a>
						<div id="nav_3" class="nav_div">
							<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(26).getGoods_picture()%>" />
							<ul>
								<li><a href="show.jsp?kind_id=26">花生</a><a href="show.jsp?kind_id=27">腰果</a></li>
								<li><a href="show.jsp?kind_id=28">板栗</a><a href="show.jsp?kind_id=29">杏仁</a></li>
								<li><a href="show.jsp?kind_id=30">榛子</a><a href="show.jsp?kind_id=31">瓜子</a></li>
								<li><a href="show.jsp?kind_id=32">开心果</a></li>
								<li><a href="show.jsp?kind_id=33">夏威夷果</a></li>
							</ul>
						</div>
					</li>
			<!--  		<li>
						<a href="show.jsp?kind_id=4" class="kind" id="kind4">仁果类</a>
						<div id="nav_4" class="nav_div">
							<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(32).getGoods_picture()%>" />
							<ul>
								<li><a href="show.jsp?kind_id=34">苹果</a><a href="show.jsp?kind_id=35">梨</a></li>
								<li><a href="show.jsp?kind_id=36">山楂</a><a href="show.jsp?kind_id=37">沙果</a></li>
								<li><a href="show.jsp?kind_id=38">山竹</a><a href="show.jsp?kind_id=39">柿子</a></li>
								<li><a href="show.jsp?kind_id=40">黑布林</a></li>
								<li><a href="show.jsp?kind_id=41">海棠果</a></li>
							</ul>
						</div>
						
					</li>
					<li>
						<a href="show.jsp?kind_id=5" class="kind" id="kind5">柑橘类</a>
						<div id="nav_5" class="nav_div">
							<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(44).getGoods_picture()%>" />
							<ul>
								<li><a href="show.jsp?kind_id=42">蜜橘</a><a href="show.jsp?kind_id=44">金橘</a></li>
								<li><a href="show.jsp?kind_id=43">蜜柑</a><a href="show.jsp?kind_id=45">甜橙</a></li>
								<li><a href="show.jsp?kind_id=46">柚子</a><a href="show.jsp?kind_id=47">柠檬</a></li>
								<li><a href="show.jsp?kind_id=48">砂糖橘</a></li>
								<li><a href="show.jsp?kind_id=49">葡萄柚</a></li>
							</ul>
						</div>
					</li>
					<li>
						<a href="show.jsp?kind_id=6" class="kind" id="kind6">瓜类</a>
						<div id="nav_6" class="nav_div">
							<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(53).getGoods_picture()%>" />
							<ul>
								<li><a href="show.jsp?kind_id=50">西瓜</a><a href="show.jsp?kind_id=51">甜瓜</a></li>
								<li><a href="show.jsp?kind_id=53">香瓜</a><a href="show.jsp?kind_id=54">木瓜</a></li>
								<li><a href="show.jsp?kind_id=55">乳瓜</a><a href="show.jsp?kind_id=56">白兰</a></li>
								<li><a href="show.jsp?kind_id=52">哈密瓜</a></li>
								<li><a href="show.jsp?kind_id=56">黄河蜜</a></li>
							</ul>
						</div>
						
					</li>
					<li>
						<a href="show.jsp?kind_id=7" class="kind" id="kind7">其他</a>
						<div id="nav_7" class="nav_div">
							<img src="<%=Factory_goods_info.getGoodsInfoByGoodsId(60).getGoods_picture()%>" />
							<ul>
								<li><a href="show.jsp?kind_id=57">菠萝</a><a href="show.jsp?kind_id=58">芒果</a></li>
								<li><a href="show.jsp?kind_id=59">椰子</a><a href="show.jsp?kind_id=60">栗子</a></li>
								<li><a href="show.jsp?kind_id=61">榴莲</a><a href="show.jsp?kind_id=62">香蕉</a></li>
								<li><a href="show.jsp?kind_id=63">石榴</a><a href="show.jsp?kind_id=64">芭乐</a></li>
								<li><a href="show.jsp?kind_id=65">拐枣</a><a href="show.jsp?kind_id=66">莲子</a></li>
							</ul>
						</div>
					</li>
					-->
				</ul>
			</div>
		</div>
		
		
	</div>
	<script>
		function submitToShow()
		{
			document.getElementById("searchForm").submit();
		}
	</script>
	<!--头部内容结束-->