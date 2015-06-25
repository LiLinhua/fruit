package fruit.dao.factory;

import java.util.List;

import fruit.dao.proxy.Proxy_comment_info;
import fruit.vo.Vo_comment_info;

public class Factory_comment_info {
	public static List<Vo_comment_info> getGoodsCommentByGoodsId(int goods_id) throws Exception
	{
		return new Proxy_comment_info().getGoodsCommentByGoodsId(goods_id);
	}
	public static boolean addComment(int goods_id, int cus_id, String cus_name, String comment_tittle, String comment_content, int goods_score) throws Exception
	{
		return new Proxy_comment_info().addCemment(goods_id, cus_id, cus_name, comment_tittle, comment_content, goods_score);
	}
	public static Vo_comment_info getCommentByCommentId(int comment_id) throws Exception
	{
		return new Proxy_comment_info().getCemmentByCommentId(comment_id);
	}
}
