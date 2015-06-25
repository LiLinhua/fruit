package fruit.dao.proxy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fruit.dao.dbc.DatabaseConnection;
import fruit.vo.Vo_goods_info;

public class Proxy_goods_info {
	
	java.sql.PreparedStatement stmt = null;
	DatabaseConnection dbc = null;
	Connection conn = null;
	public Proxy_goods_info() throws Exception
	{
		dbc = new DatabaseConnection();
		this.conn = dbc.getConnection();
	}
	
	//通过goods_id查询
	public Vo_goods_info getValueByGoodsId(int id) throws Exception
	{
		Vo_goods_info goods_info = null;
		stmt = conn.prepareStatement("select * from goods_info where goods_id =?");
	    stmt.setInt(1,id);
	    ResultSet rs = stmt.executeQuery();
	    goods_info = new Vo_goods_info();
	    while(rs.next())
	    {
	    	goods_info.setGoods_id(rs.getInt("goods_id"));
	    	
	    	goods_info.setGoods_name(rs.getString("goods_name"));
	    	
	    	goods_info.setGoods_brief(rs.getString("goods_brief"));

	    	goods_info.setGoods_details(rs.getString("goods_details"));

	    	goods_info.setGoods_price(rs.getDouble("goods_price"));
	    	
	    	goods_info.setGoods_stock(rs.getInt("goods_stock"));
	    	
	    	goods_info.setGoods_picture(rs.getString("goods_picture"));
	    	
	    	goods_info.setKind_id(rs.getInt("kind_id"));
	    	
	    	goods_info.setComment_id(rs.getInt("comment_id"));
	    	
	    	goods_info.setFather_kind_id(rs.getInt("father_kind_id"));
	    	
	    	goods_info.setAfter_sail_transform(rs.getString("after_sail_transform"));
	    	
	
	    }
	    this.conn.close();
	    return goods_info;
	}
	
	
	//通过kind_id查询
	public List<Vo_goods_info> getValueByKindId(int id) throws Exception
	{
		
		List<Vo_goods_info> goods_info_list = new ArrayList<Vo_goods_info>();
		stmt = conn.prepareStatement("select * from goods_info where kind_id=?");
	    stmt.setInt(1,id);
	    ResultSet rs = stmt.executeQuery();
	    Vo_goods_info goods_info = null;
	    while(rs.next())
	    {
	    	goods_info = new Vo_goods_info();
	    	goods_info.setGoods_id(rs.getInt("goods_id"));
	    	
	    	goods_info.setGoods_name(rs.getString("goods_name"));
	    	
	    	goods_info.setGoods_brief(rs.getString("goods_brief"));

	    	goods_info.setGoods_details(rs.getString("goods_details"));

	    	goods_info.setGoods_price(rs.getDouble("goods_price"));
	    	
	    	goods_info.setGoods_stock(rs.getInt("goods_stock"));
	    	
	    	goods_info.setGoods_picture(rs.getString("goods_picture"));
	    	
	    	goods_info.setKind_id(rs.getInt("kind_id"));
	    	
	    	goods_info.setComment_id(rs.getInt("comment_id"));
	    	
	    	goods_info.setFather_kind_id(rs.getInt("father_kind_id"));
	    	
	    	goods_info.setAfter_sail_transform(rs.getString("after_sail_transform"));
	    	
	    	goods_info_list.add(goods_info);
	    	
	    }
	    this.conn.close();
	    return goods_info_list;
	}
	
	//通过father_kind_id查询
	public List<Vo_goods_info> getValueByFatherKindId(int id) throws Exception
	{
		
		List<Vo_goods_info> goods_info_list = new ArrayList<Vo_goods_info>();
		stmt = conn.prepareStatement("select * from goods_info where father_kind_id =?");
	    stmt.setInt(1,id);
	    ResultSet rs = stmt.executeQuery();
	    Vo_goods_info goods_info = null;
	    while(rs.next())
	    {
	    	
	    	goods_info = new Vo_goods_info();
	    	goods_info.setGoods_id(rs.getInt("goods_id"));
	    	
	    	goods_info.setGoods_name(rs.getString("goods_name"));
	    	
	    	goods_info.setGoods_brief(rs.getString("goods_brief"));

	    	goods_info.setGoods_details(rs.getString("goods_details"));

	    	goods_info.setGoods_price(rs.getDouble("goods_price"));
	    	
	    	goods_info.setGoods_stock(rs.getInt("goods_stock"));
	    	
	    	goods_info.setGoods_picture(rs.getString("goods_picture"));
	    	
	    	goods_info.setKind_id(rs.getInt("kind_id"));
	    	
	    	goods_info.setComment_id(rs.getInt("comment_id"));
	    	
	    	goods_info.setFather_kind_id(rs.getInt("father_kind_id"));
	    	
	    	goods_info.setAfter_sail_transform(rs.getString("after_sail_transform"));
	    	
	    	goods_info_list.add(goods_info);
	    	
	    }
	    this.conn.close();
	    return goods_info_list;
	}
	
	//通过goods_name,goods_brief模糊查询
	public List<Vo_goods_info> getValueByGoodsNameGoodsBrief(String keyword) throws Exception
	{
		List<Vo_goods_info> goods_info_list = new ArrayList<Vo_goods_info>();
		stmt = conn.prepareStatement("select * from goods_info where goods_name like ? or goods_brief like ?" );
	    stmt.setString(1,"%"+keyword+"%");
	    stmt.setString(2,"%"+keyword+"%");
	    ResultSet rs = stmt.executeQuery();
	    Vo_goods_info goods_info = null;
	    while(rs.next())
	    {
	    	goods_info = new Vo_goods_info();
	    	goods_info.setGoods_id(rs.getInt("goods_id"));
	    	
	    	goods_info.setGoods_name(rs.getString("goods_name"));
	    	
	    	goods_info.setGoods_brief(rs.getString("goods_brief"));

	    	goods_info.setGoods_details(rs.getString("goods_details"));

	    	goods_info.setGoods_price(rs.getDouble("goods_price"));
	    	
	    	goods_info.setGoods_stock(rs.getInt("goods_stock"));
	    	
	    	goods_info.setGoods_picture(rs.getString("goods_picture"));
	    	
	    	goods_info.setKind_id(rs.getInt("kind_id"));
	    	
	    	goods_info.setComment_id(rs.getInt("comment_id"));
	    	
	    	goods_info.setFather_kind_id(rs.getInt("father_kind_id"));
	    	
	    	goods_info.setAfter_sail_transform(rs.getString("after_sail_transform"));
	    	
	    	goods_info_list.add(goods_info);
	    	
	    }
	    this.conn.close();
	    return goods_info_list;
	}
	
	//通过goods_price进行区间查询
	public List<Vo_goods_info> getValueByGoodsPrice(double price1, double price2) throws Exception
	{
		List<Vo_goods_info> goods_info_list = new ArrayList<Vo_goods_info>();
		stmt = conn.prepareStatement("select * from goods_info where gooods_price between ? and ?" );
	    stmt.setDouble(1,price1);
	    stmt.setDouble(2,price2);
	    ResultSet rs = stmt.executeQuery();
	    Vo_goods_info goods_info = null;
	    while(rs.next())
	    {
	    	goods_info = new Vo_goods_info();
	    	goods_info.setGoods_id(rs.getInt("goods_id"));
	    	
	    	goods_info.setGoods_name(rs.getString("goods_name"));
	    	
	    	goods_info.setGoods_brief(rs.getString("goods_brief"));

	    	goods_info.setGoods_details(rs.getString("goods_details"));

	    	goods_info.setGoods_price(rs.getDouble("goods_price"));
	    	
	    	goods_info.setGoods_stock(rs.getInt("goods_stock"));
	    	
	    	goods_info.setGoods_picture(rs.getString("goods_picture"));
	    	
	    	goods_info.setKind_id(rs.getInt("kind_id"));
	    	
	    	goods_info.setComment_id(rs.getInt("comment_id"));
	    	
	    	goods_info.setFather_kind_id(rs.getInt("father_kind_id"));
	    	
	    	goods_info.setAfter_sail_transform(rs.getString("after_sail_transform"));
	    	
	    	goods_info_list.add(goods_info);
	    	
	    }
	    this.conn.close();
	    return goods_info_list;
	}
}
