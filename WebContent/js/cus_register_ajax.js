var ajax_cus_name = document.getElementById("cus_name");
ajax_cus_name.onblur = function(){checkCusName(ajax_cus_name.value);};

var ajax_cus_phone = document.getElementById("cus_phone");
ajax_cus_phone.onblur = function(){checkCusPhone(ajax_cus_phone.value);};

var ajax_cus_mail = document.getElementById("cus_mail");
ajax_cus_mail.onblur = function(){checkCusMail(ajax_cus_mail.value);};


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

//异步请求验证用户名
function checkCusName(cus_name)
{
	createXMLHttp();
	xmlHttp.open("POST","Servlet_checkRegister_ajax?cus_name="+cus_name);
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
			if(checkResult == "nameTrue")
			{
				document.getElementById("nameError").innerHTML = "<font color='red'>用户名已经存在</font>";
			}else if(checkResult == "nameFalse")
			{
				document.getElementById("nameError").innerHTML = "<font color='yellowgreen'>用户名可用</font>";
			}else
			{
				document.getElementById("nameError").innerHTML = "<font color='red'>用户名不能为空</font>";
			}
		}
	}
}


//异步请求验证手机号码
function checkCusPhone(cus_phone)
{
	createXMLHttp();
	xmlHttp.open("POST","Servlet_checkRegister_ajax?cus_phone="+cus_phone);
	xmlHttp.onreadystatechange = checkCusPhoneCallback;
	xmlHttp.send(null);
}
function checkCusPhoneCallback()
{
	if(xmlHttp.readyState == 4)
	{
		if(xmlHttp.status == 200)
		{
			var checkResult = xmlHttp.responseText;
			if(checkResult == "phoneTrue")
			{
				document.getElementById("phoneError").innerHTML = "<font color='red'>手机号码已被使用</font>";
			}else if(checkResult == "phoneFalse")
			{
				document.getElementById("phoneError").innerHTML = "<font color='yellowgreen'>手机号码可用</font>";
			}else
			{
				document.getElementById("phoneError").innerHTML = "<font color='red'>手机号码不能为空</font>";
			}
		}
	}
}


//异步请求验证用户邮箱
function checkCusMail(cus_mail)
{
	createXMLHttp();
	xmlHttp.open("POST","Servlet_checkRegister_ajax?cus_mail="+cus_mail);
	xmlHttp.onreadystatechange = checkCusMailCallback;
	xmlHttp.send(null);
}
function checkCusMailCallback()
{
	if(xmlHttp.readyState == 4)
	{
		if(xmlHttp.status == 200)
		{
			var checkResult = xmlHttp.responseText;
			if(checkResult == "mailTrue")
			{
				document.getElementById("mailError").innerHTML = "<font color='red'>邮箱已被使用</font>";
			}else if(checkResult == "mailFalse")
			{
				document.getElementById("mailError").innerHTML = "<font color='yellowgreen'>邮箱可用</font>";
			}else
			{
				document.getElementById("mailError").innerHTML = "<font color='red'>邮箱不能为空</font>";
			}
		}
	}
}