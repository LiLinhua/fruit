package fruit.dao.factory;

import java.util.List;

import fruit.dao.proxy.Proxy_orderItem_info;
import fruit.vo.Vo_orderItem_info;

public class Factory_orderItem_info {
	public static boolean addItem(int cus_id, String cus_name, int goods_id, String goods_name, double goods_each_price, int goods_quantity, double goods_total_price, String cus_address) throws Exception
	{
		return new Proxy_orderItem_info ().addItem(cus_id, cus_name, goods_id, goods_name, goods_each_price,goods_quantity, goods_total_price, cus_address);
	}
	public static Vo_orderItem_info getOrderItemByOrderItemId(int orderItem_id) throws Exception
	{
		return new Proxy_orderItem_info().getOrderItemByOrderItemId(orderItem_id);
	}
	public static List<Vo_orderItem_info> getOrderItemByCusName(String cus_name) throws Exception
	{
		return new Proxy_orderItem_info().getOrderItemByCusName(cus_name);
	}
}
