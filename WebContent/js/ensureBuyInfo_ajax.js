var goods_id = document.getElementById("goods_id");
var goods_num = document.getElementById("buy_num_input");
		goods_num.onkeyup = function(){changeTotalPrice();};
		goods_num.onclick = function(){changeTotalPrice();};
		function changeTotalPrice()
		{
			var goods_each_price = document.getElementById("goods_each_price");
			var goods_total_price = document.getElementById("goods_total_price_span");
			goods_total_price.innerHTML = (goods_num.value * goods_each_price.value).toFixed(2);
			goods_total_price.value = (goods_num.value * goods_each_price.value).toFixed(2);
		}
		
		var ensureBuy = document.getElementById("ensureBuy");
		ensureBuy.onclick = function (){checkCusName(goods_num.value);};
		var xmlHttp;
		function createXMLHttp()
		{
			if(window.XMLHttpRequest)
			{
				xmlHttp = new XMLHttpRequest();
			}else
			{
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}


		function checkCusName(goods_num_value)
		{
			createXMLHttp();
			xmlHttp.open("POST","Servlet_dealBuy_ajax?goods_id="+goods_id.value+"&goods_quantity="+goods_num_value);
			xmlHttp.onreadystatechange = checkCusNameCallback;
			xmlHttp.send(null);
		}
		function checkCusNameCallback()
		{
			if(xmlHttp.readyState == 4)
			{
				if(xmlHttp.status == 200)
				{
					var checkResult = xmlHttp.responseText;
					if(checkResult == "true")
					{
						document.getElementById("resultTips").innerHTML = "<font>订单提交成功，请耐心等候发货<a href='myOrderItem.jsp'>查看我的订单</a></font>";
					}else
					{
						document.getElementById("resultTips").innerHTML = "<font>订单提交失败,请重新操作</font>";
					}
				}
			}
		}
