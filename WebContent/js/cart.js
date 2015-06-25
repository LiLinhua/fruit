	var price = document.getElementsByName("goods_id_str");
	var goods_each_price = document.getElementsByName("goods_each_price");
	var num = document.getElementsByName("num");
	document.getElementById("cart_buy_a").style.display = "none";
	for (var j = 0; j<price.length; j++) 
	{
		price[j].addEventListener("click",count_total_price);
		num[j].addEventListener("click",count_total_price);
	}
	
	function count_total_price()
	{
		var sum = 0;
		var j = 0;
		for(var i = 0; i<price.length; i++)
		{
			if(price[i].checked)
			{
				if(num[i].value>0)
				{
					sum+=(goods_each_price[i].value*num[i].value);	
				}
				j++;
			}
		}	
		document.getElementById("cart_goods_buy_total_num").innerHTML = j;
		document.getElementById("cart_goods_buy_total_price").innerHTML= sum;
		if(sum == "0")
		{
			document.getElementById("cart_buy_a").style.display = "none";
		}else
		{
			document.getElementById("cart_buy_a").style.display = "block";
		}
	}
	
	var goods_id_str = "";
	var goods_quantity_str = "";
	var cart_buy_a = document.getElementById("cart_buy_a");
	
	cart_buy_a.onclick = function(){addToCart();};
	
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
	function addToCart()
	{
		
		var goods_id = document.getElementsByName("goods_id_str");
		var num = document.getElementsByName("num");
		
		for(var i = 0; i<goods_id.length; i++)
		{
			
			if(goods_id[i].checked && i<goods_id.length-1)
			{
				goods_id_str += goods_id[i].value+",";
				goods_quantity_str += num[i].value+",";
			}else if(goods_id[i].checked && i == goods_id.length-1)
			{
				goods_id_str += goods_id[i].value;
				goods_quantity_str += num[i].value;
			}
		}
		var numFlag = true;
		for(var j = 0; j<num.length; j++)
		{
			if(num[j] == "" && num[j].checked)
			{
				numFlag = false;
			}
		}
		if(!numFlag)
		{
			alert("所选商品的数量不能为空！");
		}else if(numFlag)
		{
			createXMLHttp();
			xmlHttp.open("POST","Servlet_doCart_ajax?doFlag=addMuchCartItem&goods_id_str="+goods_id_str+"&goods_quantity_str="+ goods_quantity_str);
			xmlHttp.onreadystatechange = addToCartCallback;
			xmlHttp.send(null);
			
		}
		
	}
	function addToCartCallback()
	{
		
		if(xmlHttp.readyState == 4)
		{
			if(xmlHttp.status == 200)
			{
				var hiddenA = document.getElementById("hiddenA");
				var text = xmlHttp.responseText;
				if(text == "all")
				{
					
					hiddenA.href = "cart.jsp?addCartFlag=all";
					hiddenA.click();
				}else if(text == "none")
				{
					hiddenA.href = "cart.jsp?addCartFlag=none";
					hiddenA.click();
				}else
				{
					hiddenA.href = "cart.jsp?addCartFlag=part";
					hiddenA.click();
				}
			}
		}
	}
	
	