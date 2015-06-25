var cus_name = document.getElementById("cus_name");
var cus_phone = document.getElementById("cus_phone");
var cus_mail = document.getElementById("cus_mail");
var cus_postcode = document.getElementById("cus_postcode");
var cus_address = document.getElementById("cus_address");


cus_name.onblur = function(){checkName();};
cus_name.onkeyup = function(){checkName();};

cus_postcode.onblur = function(){checkPostcode();};
cus_postcode.onkeyup = function(){checkPostcode();};

cus_address.onblur = function(){checkAddress();};
cus_address.onkeyup = function(){checkAddress();};

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
function checkPostcode()
{
	var cus_postcode = document.getElementById("cus_postcode");
	var postcodeError = document.getElementById("postcodeError");
	var pattern = /^[0-9]{6}$/;
	var result = pattern.exec(cus_postcode.value);
	if(cus_postcode.value == null || cus_postcode.value == "")
	{
		postcodeError.innerHTML = "<font color='red'>邮政编码不能为空</font>";

		
	}else if(!result)
	{
		postcodeError.innerHTML = "<font color='red'>邮政编码格式错误</font>";

	}else
	{
		postcodeError.innerHTML = "";
	}
}
function checkAddress()
{
	var cus_address = document.getElementById("cus_address");
	var addressError = document.getElementById("addressError");

	if(cus_address.value == null || cus_address.value == "")
	{
		addressError.innerHTML = "<font color='red'>地址不能为空</font>";

	}else
	{
		addressError.innerHTML = "";
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
		phoneError.innerHTML = "<font color='red'>手机号码不能为空</font>";

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
	
	
	var cus_postcode = document.getElementById("cus_postcode");
	var postcodeError = document.getElementById("postcodeError");
	var pattern = /^[0-9]{6}$/;
	var result = pattern.exec(cus_password.value);
	
	var cus_address = document.getElementById("cus_address");
	var addressError = document.getElementById("addressError");
	
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
		
	}else if(cus_postcode.value == null || cus_postcode.value == "")
	{
		postcodeError.innerHTML = "<font color='red'>邮政编码不能为空</font>";
		cus_postcode.focus();
		return false;
		
	}else if(!result)
	{
		postcodeError.innerHTML = "<font color='red'>邮政编码格式错误</font>";
		cus_postcode.focus();
		return false;

	}else if(cus_address.value == null || cus_address.value == "")
	{
		password1Error.innerHTML = "<font color='red'>地址不能为空</font>";
		cus_address.focus();
		return false;

	}else if(result2 == null || result2 == "")
	{
		phoneError.innerHTML = "<font color='red'>手机号码只能是11位数字</font>";
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
var back = document.getElementById("updatePersonInfoBack");
back.onclick = function (){historyback();};
function historyback()
{
	window.history.back(-1);
	
}