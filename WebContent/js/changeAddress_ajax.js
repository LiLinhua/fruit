 var newAddress = document.getElementById("newAddress")
		var change_submit = document.getElementById("change_submit");
		change_submit.onclick = function (){checkCusName(newAddress.value);};
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


		function checkCusName(address_value)
		{
			createXMLHttp();
			xmlHttp.open("POST","Servlet_updatePersonInfo_ajax?cus_address=" + address_value);
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
						document.getElementById("changeFlag").innerHTML = "<font'>地址修改成功</font>";
					}else
					{
						document.getElementById("changeFlag").innerHTML = "<font>地址修改失败</font>";
					}
				}
			}
		}
		 var back = document.getElementById("back");
		 back.onclick = function(){backTo();};
		 function backTo()
		 {
			 window.history.back(-1);
		 }