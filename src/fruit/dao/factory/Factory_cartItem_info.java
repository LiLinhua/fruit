package fruit.dao.factory;

import java.util.List;

import fruit.dao.proxy.Proxy_cartItem_info;
import fruit.vo.Vo_cartItem_info;

public class Factory_cartItem_info {
	public static boolean addItem(int cus_id, String cus_name, int goods_id, String goods_name, double goods_each_price, int goods_quantity, double goods_total_price) throws Exception
	{
		return new Proxy_cartItem_info ().addItem(cus_id, cus_name, goods_id, goods_name, goods_each_price,goods_quantity, goods_total_price);
	}
	public static Vo_cartItem_info getcartItemByCartItemId(int cartItem_id) throws Exception
	{
		return new Proxy_cartItem_info().getCartItemByCartItemId(cartItem_id);
	}
	public static List<Vo_cartItem_info> getCartItemByCusName(String cus_name) throws Exception
	{
		return new Proxy_cartItem_info().getCartItemByCusName(cus_name);
	}
	public static boolean deleteItemByItemId(int cartItem_id) throws Exception
	{
		return new Proxy_cartItem_info ().deleteItemByItemId(cartItem_id);
	}
}
