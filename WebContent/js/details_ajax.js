var zoom_main_img = document.getElementById("details_small_pic");
//			var img[] = document.getElementsByClassName("zoom_ul_img");
			function change_img(a){
				zoom_main_img.src = a;
			}
			
			function checkBuyNum()
			{
				var buyNum = document.getElementById("buy_num");
				if(buyNum.value == "" || buyNum.value == null)
				{
					document.getElementById("buy_num_tips").innerHTML = "<font color='red'>请输入购买数量</font>";
					return false;
				}
				var goodsEachPrice = document.getElementById("goodsEachPrice");
				var goods_total_price = document.getElementById("goods_total_price");
				goods_total_price.value =(goodsEachPrice.value * buyNum.value).toFixed(2);
				return true;
			}
			
			function checkAddCartGoodsNumber()
			{
				var buyNum = document.getElementById("buy_num");
				if(buyNum.value == "" || buyNum.value == null)
				{
					document.getElementById("buy_num_tips").innerHTML = "<font color='red'>请输入购买数量</font>";
				}else
				{
					var goodsEachPrice = document.getElementById("goodsEachPrice");
					var goods_total_price = document.getElementById("goods_total_price");
					goods_total_price.value = (goodsEachPrice.value * buyNum.value.value).toFixed(2);
					var myForm = document.getElementById("myForm");
					myForm.action = "Servlet_addGoodsToCart";
					document.getElementById("myForm").submit();
				}
			}
			
			var addCart = document.getElementById("addCart");
			var goods_id = document.getElementById("goods_id");
			addCart.onclick = function(){addToCart();};
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
				var buyNum = document.getElementById("buy_num");
				var buyNumValue = buyNum.value;
				if(buyNumValue == "" || buyNumValue == null)
				{
					document.getElementById("buy_num_tips").innerHTML = "<font color='red'>请输入购买数量</font>";
				}else
				{
					createXMLHttp();
					xmlHttp.open("POST","Servlet_doCart_ajax?doFlag=addCartItem&goods_id="+goods_id.value+"&goods_quantity="+ buyNumValue);
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
						if(text == "right")
						{
							
							hiddenA.href = "cart.jsp?addCartFlag=true";
							hiddenA.click();
						}else
						{
							hiddenA.href = "cart.jsp?addCartFlag=false";
							hiddenA.click();
						}
					}
				}
			}