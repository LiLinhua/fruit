package fruit.dao.proxy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fruit.dao.dbc.DatabaseConnection;
import fruit.vo.Vo_comment_info;

public class Proxy_comment_info {
	java.sql.PreparedStatement stmt = null;
	DatabaseConnection dbc = null;
	Connection conn = null;
	public Proxy_comment_info() throws Exception
	{
		dbc = new DatabaseConnection();
		this.conn = dbc.getConnection();
	}
	public boolean addCemment(int goods_id, int cus_id, String cus_name, String comment_tittle, String comment_content, int goods_score ) throws SQLException
	{
		boolean flag = false;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    String comment_time =(String) df.format(new Date());//获取当前系统时间
		stmt = conn.prepareStatement("insert into comment_info(comment_tittle, comment_content, cus_id, cus_name, goods_id, goods_score, comment_time) values(?,?,?,?,?,?,?)");
	    stmt.setString(1,comment_tittle);
	    stmt.setString(2,comment_content);
	    stmt.setInt(3,cus_id);
	    stmt.setString(4,cus_name);
	    stmt.setInt(5,goods_id);
	    stmt.setInt(6,goods_score);
	    stmt.setString(7,comment_time);
	    int rs = stmt.executeUpdate();
	    if(rs > 0)
	    {
	    	flag = true;
	    }
	    this.conn.close();
		return flag;
	}
	public Vo_comment_info getCemmentByCommentId(int comment_id ) throws SQLException
	{
		stmt = conn.prepareStatement("select * from comment_info where comment_id=?");
	    stmt.setInt(1,comment_id);
	    ResultSet rs = stmt.executeQuery();
	    Vo_comment_info vo_comment_info = null;
	    while(rs.next())
	    {
	    	vo_comment_info = new Vo_comment_info();
	    	
	    	vo_comment_info.setGoods_id(rs.getInt("goods_id"));
	    	
	    	vo_comment_info.setCus_id(rs.getInt("cus_id"));
	    	
	    	vo_comment_info.setComment_id(rs.getInt("comment_id"));

	    	vo_comment_info.setComment_tittle(rs.getString("comment_tittle"));

	    	vo_comment_info.setCus_name(rs.getString("cus_name"));
	    	
	    	vo_comment_info.setGoods_score(rs.getInt("goods_score"));
	    	
	    	vo_comment_info.setComment_content(rs.getString("comment_content"));
	    	
	    	vo_comment_info.setComment_time(rs.getString("comment_time"));
	    	
	    }
	    this.conn.close();
		return vo_comment_info;
	}
	public List<Vo_comment_info> getGoodsCommentByGoodsId(int goods_id) throws SQLException
	{
		List<Vo_comment_info> comments_list = new ArrayList<Vo_comment_info>();
		stmt = conn.prepareStatement("select * from comment_info where goods_id =?");
	    stmt.setInt(1,goods_id);
	    ResultSet rs = stmt.executeQuery();
	    Vo_comment_info vo_comment_info = null;
	    while(rs.next())
	    {
	    	vo_comment_info = new Vo_comment_info();
	    	
	    	vo_comment_info.setGoods_id(rs.getInt("goods_id"));
	    	
	    	vo_comment_info.setCus_id(rs.getInt("cus_id"));
	    	
	    	vo_comment_info.setComment_id(rs.getInt("comment_id"));

	    	vo_comment_info.setComment_tittle(rs.getString("comment_tittle"));

	    	vo_comment_info.setCus_name(rs.getString("cus_name"));
	    	
	    	vo_comment_info.setGoods_score(rs.getInt("goods_score"));
	    	
	    	vo_comment_info.setComment_content(rs.getString("comment_content"));
	    	
	    	vo_comment_info.setComment_time(rs.getString("comment_time"));
	    	
	    	comments_list.add(vo_comment_info);
	    	
	    }
	    this.conn.close();
	    return comments_list;
	}

}
