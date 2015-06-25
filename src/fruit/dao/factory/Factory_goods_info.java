package fruit.dao.factory;

import java.util.List;

import fruit.dao.proxy.Proxy_goods_info;
import fruit.vo.Vo_goods_info;

public class Factory_goods_info {
	public static Vo_goods_info getGoodsInfoByGoodsId(int goods_id) throws Exception
	{
		return new Proxy_goods_info().getValueByGoodsId(goods_id);
	}
	public static List<Vo_goods_info> getGoodsInfoByKindId(int Kind_id) throws Exception
	{
		return new Proxy_goods_info().getValueByKindId(Kind_id);
	}
	public static List<Vo_goods_info> getGoodsInfoByFatherKindId(int Kind_id) throws Exception
	{
		return new Proxy_goods_info().getValueByFatherKindId(Kind_id);
	}
	public static List<Vo_goods_info> getValueByGoodsNameGoodsBrief(String keyword) throws Exception
	{
		return new Proxy_goods_info().getValueByGoodsNameGoodsBrief(keyword);
	}
	public static List<Vo_goods_info> getGoodsInfoByGoodsPrice(double price1, double price2) throws Exception
	{
		return new Proxy_goods_info().getValueByGoodsPrice(price1, price2);
	}
	
}
