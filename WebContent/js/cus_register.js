var cus_name = document.getElementById("cus_name");
var cus_password = document.getElementById("cus_password");
var cus_password1 = document.getElementById("cus_password1");
var cus_phone = document.getElementById("cus_phone");
var cus_mail = document.getElementById("cus_mail");


cus_name.onblur = function(){checkName();};
cus_name.onkeyup = function(){checkName();};

cus_password.onblur = function(){checkPassword();};
cus_password.onkeyup = function(){checkPassword();};

cus_password1.onblur = function(){checkPassword1();};
cus_password1.onkeyup = function(){checkPassword1();};

cus_phone.onblur = function(){checkPhone();};
cus_phone.onkeyup = function(){checkPhone();};

cus_mail.onblur = function(){checkMail();};
cus_mail.onkeyup = function(){checkMail();};

function checkName()
{
	var cus_name = document.getElementById("cus_name");
	var nameError = document.getElementById("nameError");
	
	if(cus_name.value == null || cus_name.value == "")
	{
		nameError.innerHTML = "<font color='red'>用户名不能为空</font>";

		
	}else
	{
		nameError.innerHTML = "";
	}
}
function checkPassword()
{
	var cus_password = document.getElementById("cus_password");
	var passwordError = document.getElementById("passwordError");
	var pattern = /^[a-zA-Z0-9]{6,20}$/;
	var result = pattern.exec(cus_password.value);
	if(cus_password.value == null || cus_password.value == "")
	{
		passwordError.innerHTML = "<font color='red'>密码不能为空</font>";

		
	}else if(!result)
	{
		passwordError.innerHTML = "<font color='red'>密码必须是6-20位字母数字</font>";

	}else
	{
		passwordError.innerHTML = "";
	}
}
function checkPassword1()
{
	var cus_password = document.getElementById("cus_password");
	var cus_password1 = document.getElementById("cus_password1");
	var password1Error = document.getElementById("password1Error");

	if(cus_password.value != cus_password1.value)
	{
		password1Error.innerHTML = "<font color='red'>密码不一致</font>";

	}else
	{
		password1Error.innerHTML = "";
	}
}
function checkPhone()
{
	var cus_phone = document.getElementById("cus_phone");
	var phoneError = document.getElementById("phoneError");
	var pattern = /^[0-9]{11}$/;
	var result = pattern.exec(cus_phone.value);
	if(!result)
	{
		phoneError.innerHTML = "<font color='red'>必须是11位数字</font>";

	}else
	{
		phoneError.innerHTML = "";
	}
}
function checkMail()
{
	var cus_mail = document.getElementById("cus_mail");
	var mailError = document.getElementById("mailError");
	var pattern = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
	var result = pattern.exec(cus_mail.value);
	if(!result)
	{
		mailError.innerHTML = "<font color='red'>邮箱格式错误</font>";
	
	}else
	{
		mailError.innerHTML = "";
	}
}
function checkForm()
{
	
	var cus_name = document.getElementById("cus_name");
	var nameError = document.getElementById("nameError");
	
	
	var cus_password = document.getElementById("cus_password");
	var passwordError = document.getElementById("passwordError");
	var pattern_cus_password = /^[a-zA-Z0-9]{6,20}$/;
	var result1 = pattern_cus_password.exec(cus_password.value);
	
	var cus_password1 = document.getElementById("cus_password1");
	var password1Error = document.getElementById("password1Error");
	
	var cus_phone = document.getElementById("cus_phone");
	var phoneError = document.getElementById("phoneError");
	var pattern_phone = /^[0-9]{11}$/;
	var result2 = pattern_phone.exec(cus_phone.value);
	
	var cus_mail = document.getElementById("cus_mail");
	var mailError = document.getElementById("mailError");
	var pattern_mail = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
	var result3 = pattern_mail.exec(cus_mail.value);
	
	if(cus_name.value == null || cus_name.value == "")
	{
		nameError.innerHTML = "<font color='red'>用户名不能为空</font>";
		cus_name.focus();
		return false;
		
	}else if(cus_password.value == null || cus_password.value == "")
	{
		passwordError.innerHTML = "<font color='red'>密码不能为空</font>";
		cus_password.focus();
		return false;
		
	}else if(cus_password1.value == null || cus_password1.value == "")
	{
		
		password1Error.innerHTML = "<font color='red'>确认密码不能为空</font>";
		cus_password1.focus();
		return false;
		
	}else if(cus_password.value != cus_password1.value)
	{
		password1Error.innerHTML = "<font color='red'>密码不一致</font>";
		cus_password1.focus();
		return false;
	}else if(result1 == null)
	{
		passwordError.innerHTML = "<font color='red'>密码必须是6-20位字母数字</font>";
		cus_password.focus();
		return false;
	}else if(result2 == null || result2 == "")
	{
		phoneError.innerHTML = "<font color='red'>必须是11位数字</font>";
		cus_phone.focus();	
		return false;
	}else if( result3 == null || result3 == "")
	{
		mailError.innerHTML = "<font color='red'>邮箱格式错误</font>";
		cus_mail.focus();	
		return false;
	}else
	{
		return true;
	}
	
}
