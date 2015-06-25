package fruit.dao.proxy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fruit.dao.dbc.DatabaseConnection;
import fruit.vo.Vo_orderItem_info;

public class Proxy_orderItem_info {
	java.sql.PreparedStatement stmt = null;
	DatabaseConnection dbc = null;
	Connection conn = null;
	public Proxy_orderItem_info() throws Exception
	{
		dbc = new DatabaseConnection();
		this.conn = dbc.getConnection();
	}
	
    
	public boolean addItem(int cus_id, String cus_name, int goods_id, String goods_name, double goods_each_price, int goods_quantity, double goods_total_price, String cus_address) throws SQLException
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    String orderItem_time =(String) df.format(new Date());//获取当前系统时间
	    String orderItem = "正在准备发货";
		boolean flag = false;
		stmt = conn.prepareStatement("insert into orderItem_info(cus_id, cus_name, goods_id, goods_name, goods_each_price, goods_quantity, goods_total_price, orderItem_time, cus_address, orderItem_state) values(?,?,?,?,?,?,?,?,?,?)");
	    stmt.setInt(1,cus_id);
	    stmt.setString(2,cus_name);
	    stmt.setInt(3,goods_id);
	    stmt.setString(4,goods_name);
	    stmt.setDouble(5,goods_each_price);
	    stmt.setInt(6,goods_quantity);
	    stmt.setDouble(7,goods_total_price);
	    stmt.setString(8,orderItem_time);
	    stmt.setString(9,cus_address);
	    stmt.setString(10,orderItem);
	    
	    int rs = stmt.executeUpdate();
	    
	   
	    if(rs>0)
	    {
	    	flag = true;
	    }
	    this.conn.close();
		return flag;
		
	}
	
	public Vo_orderItem_info getOrderItemByOrderItemId(int orderItem_id ) throws SQLException
	{
		stmt = conn.prepareStatement("select * from orderItem_info where orderItem_id=?");
	    stmt.setInt(1,orderItem_id);
	    ResultSet rs = stmt.executeQuery();
	    Vo_orderItem_info vo_orderItem_info = null;
	    while(rs.next())
	    {
	    	vo_orderItem_info = new Vo_orderItem_info();
	    	
	    	vo_orderItem_info.setOrderItem_id(rs.getInt("orderItem_id"));
	    	
	    	vo_orderItem_info.setCus_id(rs.getInt("cus_id"));
	    	
	    	vo_orderItem_info.setGoods_id(rs.getInt("goods_id"));

	    	vo_orderItem_info.setGoods_quantity(rs.getInt("goods_quantity"));

	    	vo_orderItem_info.setCus_name(rs.getString("cus_name"));
	    	
	    	vo_orderItem_info.setGoods_name(rs.getString("goods_name"));
	    	
	    	vo_orderItem_info.setOrderItem_state(rs.getString("orderItem_state"));
	    	
	    	vo_orderItem_info.setGoods_each_price(rs.getDouble("goods_each_price"));
	    	
	    	vo_orderItem_info.setGoods_total_price(rs.getDouble("goods_total_price"));
	    	
	    	vo_orderItem_info.setOrderItem_time(rs.getString("orderItem_time"));
	    }
	    this.conn.close();
		return vo_orderItem_info;
	}
	public List<Vo_orderItem_info> getOrderItemByCusName(String cus_name) throws SQLException
	{
		List<Vo_orderItem_info> orderItems_list = new ArrayList<Vo_orderItem_info>();
		stmt = conn.prepareStatement("select * from orderItem_info where cus_name =?");
	    stmt.setString(1,cus_name);
	    ResultSet rs = stmt.executeQuery();
	    Vo_orderItem_info vo_orderItem_info = null;
	    while(rs.next())
	    {
	    	vo_orderItem_info = new Vo_orderItem_info();
	    	
	    	vo_orderItem_info.setOrderItem_id(rs.getInt("orderItem_id"));
	    	
	    	vo_orderItem_info.setCus_id(rs.getInt("cus_id"));
	    	
	    	vo_orderItem_info.setGoods_id(rs.getInt("goods_id"));

	    	vo_orderItem_info.setGoods_quantity(rs.getInt("goods_quantity"));

	    	vo_orderItem_info.setCus_name(rs.getString("cus_name"));
	    	
	    	vo_orderItem_info.setGoods_name(rs.getString("goods_name"));
	    	
	    	vo_orderItem_info.setOrderItem_state(rs.getString("orderItem_state"));
	    	
	    	vo_orderItem_info.setGoods_each_price(rs.getDouble("goods_each_price"));
	    	
	    	vo_orderItem_info.setGoods_total_price(rs.getDouble("goods_total_price"));
	    	
	    	vo_orderItem_info.setOrderItem_time(rs.getString("orderItem_time"));
	    	
	    	orderItems_list.add(vo_orderItem_info);
	    }
	    this.conn.close();
		return orderItems_list;
	}
}
