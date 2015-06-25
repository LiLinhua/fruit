package fruit.dao.proxy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fruit.dao.dbc.DatabaseConnection;
import fruit.vo.Vo_cartItem_info;

public class Proxy_cartItem_info {
	java.sql.PreparedStatement stmt = null;
	DatabaseConnection dbc = null;
	Connection conn = null;
	public Proxy_cartItem_info() throws Exception
	{
		dbc = new DatabaseConnection();
		this.conn = dbc.getConnection();
	}
	
    
	public boolean addItem(int cus_id, String cus_name, int goods_id, String goods_name, double goods_each_price, int goods_quantity, double goods_total_price) throws SQLException
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    String cartItem_time =(String) df.format(new Date());//获取当前系统时间
		stmt = conn.prepareStatement("insert into cartItem_info(cus_id, cus_name, goods_id, goods_name, goods_each_price, goods_quantity, goods_total_price, cartItem_time) values(?,?,?,?,?,?,?,?)");
	    stmt.setInt(1,cus_id);
	    stmt.setString(2,cus_name);
	    stmt.setInt(3,goods_id);
	    stmt.setString(4,goods_name);
	    stmt.setDouble(5,goods_each_price);
	    stmt.setInt(6,goods_quantity);
	    stmt.setDouble(7,goods_total_price);
	    stmt.setString(8,cartItem_time);
	    int rs = stmt.executeUpdate();
	    if(rs>0)
	    {
	    	this.conn.close();
	    	return true;
	    }
	    else
	    {
	    	this.conn.close();
	    	return false;
	    }
	    
	
	}
	
	public Vo_cartItem_info getCartItemByCartItemId(int cartItem_id ) throws SQLException
	{
		stmt = conn.prepareStatement("select * from cartItem_info where cartItem_id=?");
	    stmt.setInt(1,cartItem_id);
	    ResultSet rs = stmt.executeQuery();
	    Vo_cartItem_info vo_cartItem_info = null;
	    while(rs.next())
	    {
	    	vo_cartItem_info = new Vo_cartItem_info();
	    	
	    	vo_cartItem_info.setCartItem_id(rs.getInt("cartItem_id"));
	    	
	    	vo_cartItem_info.setCus_id(rs.getInt("cus_id"));
	    	
	    	vo_cartItem_info.setGoods_id(rs.getInt("goods_id"));

	    	vo_cartItem_info.setGoods_quantity(rs.getInt("goods_quantity"));

	    	vo_cartItem_info.setCus_name(rs.getString("cus_name"));
	    	
	    	vo_cartItem_info.setGoods_name(rs.getString("goods_name"));
	    	
	    	vo_cartItem_info.setGoods_each_price(rs.getDouble("goods_each_price"));
	    	
	    	vo_cartItem_info.setGoods_total_price(rs.getDouble("goods_total_price"));
	    	
	    	vo_cartItem_info.setCartItem_time(rs.getString("cartItem_time"));
	    }
	    this.conn.close();
		return vo_cartItem_info;
	}
	public List<Vo_cartItem_info> getCartItemByCusName(String cus_name) throws SQLException
	{
		List<Vo_cartItem_info> cartItems_list = new ArrayList<Vo_cartItem_info>();
		stmt = conn.prepareStatement("select * from cartItem_info where cus_name =?");
	    stmt.setString(1,cus_name);
	    ResultSet rs = stmt.executeQuery();
	    Vo_cartItem_info vo_cartItem_info = null;
	    while(rs.next())
	    {
	    	vo_cartItem_info = new Vo_cartItem_info();
	    	
	    	vo_cartItem_info.setCartItem_id(rs.getInt("cartItem_id"));
	    	
	    	vo_cartItem_info.setCus_id(rs.getInt("cus_id"));
	    	
	    	vo_cartItem_info.setGoods_id(rs.getInt("goods_id"));

	    	vo_cartItem_info.setGoods_quantity(rs.getInt("goods_quantity"));

	    	vo_cartItem_info.setCus_name(rs.getString("cus_name"));
	    	
	    	vo_cartItem_info.setGoods_name(rs.getString("goods_name"));
	    	
	    	vo_cartItem_info.setGoods_each_price(rs.getDouble("goods_each_price"));
	    	
	    	vo_cartItem_info.setGoods_total_price(rs.getDouble("goods_total_price"));
	    	
	    	vo_cartItem_info.setCartItem_time(rs.getString("cartItem_time"));
	    	
	    	cartItems_list.add(vo_cartItem_info);
	    }
	    this.conn.close();
		return cartItems_list;
	}
	
	public boolean deleteItemByItemId(int cartItem_id) throws SQLException
	{
		boolean flag = false;
		stmt = conn.prepareStatement("delete from cartItem_info where cartItem_id=?");
	    stmt.setInt(1,cartItem_id); 
	    int rs = stmt.executeUpdate();
	    if(rs>0)
	    {
	    	flag = true;
	    }
	    this.conn.close();
		return flag;
		
	}
}
