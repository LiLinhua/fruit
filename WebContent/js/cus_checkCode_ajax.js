var checkCodeAjax = document.getElementById("checkCode");
checkCodeAjax.onblur = function(){checkCodeAjaxW(checkCodeAjax.value);};

var flag = false;
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

//异步请求验证码
function checkCodeAjaxW(checkCode)
{
	createXMLHttp();
	xmlHttp.open("POST","Servlet_checkCode_ajax?checkCode="+checkCode);
	xmlHttp.onreadystatechange = checkCodeCallback;
	xmlHttp.send(null);
	return flag;
}
function checkCodeCallback()
{
	if(xmlHttp.readyState == 4)
	{
		if(xmlHttp.status == 200)
		{
			var checkResult = xmlHttp.responseText;
			if(checkResult == "true")
			{
				document.getElementById("checkCodeError").innerHTML = "<font color='yellowgreen'>验证码正确</font>";
				flag = true;
			}else if(checkResult == "false")
			{
				document.getElementById("checkCodeError").innerHTML = "<font color='red'>验证码错误</font>";
				document.getElementById("checkCode").focus();
			}else
			{
				document.getElementById("checkCodeError").innerHTML = "<font color='red'>验证码不能为空</font>";
				document.getElementById("checkCode").focus();
			}
		}
	}
}