
document.getElementById("changeCode").onclick = function (){changeCodeOnclick();};

function changeCodeOnclick()
{
	var checkCodeImg = document.getElementById("checkCodeImg");
	checkCodeImg.src = checkCodeImg.src+"?"+Math.random();

}
	function checkName()
	{
		var username = document.getElementById("username");
		if(username.value == null || username.value == "")
		{
			document.getElementById("nameError").innerHTML = "<font color='red'>请输入用户名</font>";
			username.focus();
		}else
		{
			document.getElementById("nameError").innerHTML = "";
		}
	}
	function checkpwd()
	{
		var pwd = document.getElementById("pwd");
		var pat = /^[0-9a-zA-Z]{6,20}$/;
		var flag = pat.exec(pwd.value);
		if(pwd.value == null || pwd.value == "" || !flag)
		{
			document.getElementById("pwdError").innerHTML = "<font color='red'>密码只能是6-20位字母数字</font>";
			pwd.focus();
		}else
		{
			document.getElementById("pwdError").innerHTML = "";
		}
	}
	function checkCode()
	{
		var checkCode = document.getElementById("checkCode");
		var checkCodeError = document.getElementById("checkCodeError");
		if(checkCode.value == null || checkCode.value == "")
		{
			document.getElementById("checkCodeError").innerHTML = "<font color='red'>验证码不能为空</font>";
			checkCode.focus();
		}else
		{
			document.getElementById("checkCodeError").innerHTML = "";
		}
	}
	function checkLogin()
	{
		var username = document.getElementById("username");
		var pwd = document.getElementById("pwd");
		var pat = /^[0-9a-zA-Z]{6,20}$/;
		var flag = pat.exec(pwd.value);
		var checkCode = document.getElementById("checkCode");
		var checkCodeError = document.getElementById("checkCodeError");
		
		if(username.value == null || username.value == "")
		{
			document.getElementById("nameError").innerHTML = "<font color='red'>请输入用户名</font>";
			username.focus();
			return false;
		}else if(pwd.value == null || pwd.value == "" || !flag)
		{
			document.getElementById("pwdError").innerHTML = "<font color='red'>密码只能是6-20位字母数字</font>";
			pwd.focus();
			return false;
		}else if(checkCode.value == null || checkCode.value == "")
		{
			document.getElementById("checkCodeError").innerHTML = "<font color='red'>请输入验证码</font>";
			checkCode.focus();
			return false;
		}
		else
		{
			return true;
		}
	/*	else if(checkCode.value == null || checkCode.value == "" || checkCode.value != id )
		{
			document.getElementById("checkCodeError").innerHTML = "<font color='red'>验证码输入错误</font>";
			checkCode.focus();
			return false;
		}
	*/
	}
	
	document.getElementById("username").onclick = function(){checkName();};
	document.getElementById("pwd").onclick = function(){checkpwd();};
	document.getElementById("username").onkeyup = function(){checkName();};
	document.getElementById("pwd").onkeyup = function(){checkpwd();};
	document.getElementById("checkCode").onclick = function(){checkCode();};
	document.getElementById("checkCode").onkeyup = function(){checkCode();};
