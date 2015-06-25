package fruit.dao.factory;

import fruit.dao.proxy.Proxy_cus_info;
import fruit.vo.Vo_cus_info;


public class Factory_cus_info {
	public static int getLoginResult(String cus_name, String cus_password) throws Exception
	{
			return new Proxy_cus_info().login(cus_name, cus_password);
	}
	public static int getRegisterResult(String cus_name, String cus_password, String cus_gender, String cus_phone, String cus_mail) throws Exception
	{
			return new Proxy_cus_info().register(cus_name, cus_password, cus_gender, cus_phone, cus_mail);
	}
	public static Vo_cus_info getCusInfoByName(String cus_name) throws Exception
	{
			return new Proxy_cus_info().getCusInfoByName(cus_name);
	}
	public static boolean updateInfoByCusName(String cus_old_name, String cus_new_name, String cus_gender, String cus_phone, String cus_postcode, String cus_mail, String cus_address) throws Exception
	{
		return new Proxy_cus_info().updateInfoByCusName(cus_old_name, cus_new_name, cus_gender, cus_phone, cus_postcode, cus_mail, cus_address);
	}
	public static boolean updateAddressByCusName(String cus_name, String cus_address) throws Exception
	{
		return new Proxy_cus_info().updateAddressByCusName(cus_name, cus_address);
	}
}
