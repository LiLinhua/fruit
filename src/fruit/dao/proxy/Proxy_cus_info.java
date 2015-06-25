package fruit.dao.proxy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fruit.dao.dbc.DatabaseConnection;
import fruit.vo.Vo_cus_info;

public class Proxy_cus_info {
	java.sql.PreparedStatement stmt = null;
	DatabaseConnection dbc = null;
	Connection conn = null;
	public Proxy_cus_info() throws Exception
	{
		dbc = new DatabaseConnection();
		this.conn = dbc.getConnection();
	}
	
	public int login(String cus_name, String cus_password) throws Exception{	
		int l=0;
	    try{
	      //创建SQL语句执行类
	      cus_name = new String(cus_name.getBytes("ISO-8859-1"),"UTF-8");
	      stmt = conn.prepareStatement("select * from cus_info where cus_name =?");
	      stmt.setString(1,cus_name);
	      ResultSet rs = stmt.executeQuery();
	      if(rs.next())
	      {
	    	  if(rs.getString("cus_password").equals(cus_password) )
	    	  {
	    		  l=2;
	    	  }else
	    	  {
	    		  l= 1; 
	    	  }
	      }else
	      {
	    	  l=0;
	      }
	        	     
	    }catch(Exception ex){
	      ex.printStackTrace();
	    }finally{
	    	try{
	    		conn.close();
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
		return l;
	}
	
	
	public int register(String cus_name, String cus_password, String cus_gender, String cus_phone, String cus_mail ) throws Exception{	
		int l= 0;
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    String cus_register_time =(String) df.format(new Date());//获取当前系统时间
	    try{
	    	cus_name = new String(cus_name.getBytes("ISO-8859-1"),"UTF-8");
	    	cus_gender = new String(cus_gender.getBytes("ISO-8859-1"),"UTF-8");
	      //创建SQL语句执行类
	      stmt = conn.prepareStatement("select cus_name from cus_info where cus_name=? or cus_phone=? or cus_mail=?");
		  stmt.setString(1,cus_name);
		  stmt.setString(2,cus_phone);
		  stmt.setString(3,cus_mail);
		  ResultSet rs = stmt.executeQuery();
		  if(rs.next())
		  {
			  l = 0;
		  }else
		  {
		      stmt = conn.prepareStatement("insert into cus_info(cus_name, cus_password, cus_gender, cus_phone, cus_mail, cus_register_time) values(?,?,?,?,?,?)");
		      stmt.setString(1,cus_name);
		      stmt.setString(2,cus_password);
		      stmt.setString(3,cus_gender);
		      stmt.setString(4,cus_phone);
		      stmt.setString(5,cus_mail);
		      stmt.setString(6,cus_register_time);
		      
		      int result = stmt.executeUpdate();
		      if(result>0)
		      {
		    	  l = 1;
		      } 
		  }
	    }catch(Exception ex){
	      ex.printStackTrace();
	    }finally{
	    	try{
	    		conn.close();
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
		return l;
	}
	
	public boolean updateInfoByCusName(String cus_old_name, String cus_new_name, String cus_gender, String cus_phone, String cus_postcode, String cus_mail, String cus_address) throws Exception{	
		boolean a = false;
	    try{
	      //创建SQL语句执行类
	      cus_old_name = new String(cus_old_name.getBytes("ISO-8859-1"),"UTF-8");
	      cus_new_name = new String(cus_new_name.getBytes("ISO-8859-1"),"UTF-8");
	      cus_gender = new String(cus_gender.getBytes("ISO-8859-1"),"UTF-8");
	      cus_address = new String(cus_address.getBytes("ISO-8859-1"),"UTF-8");
	      stmt = conn.prepareStatement("update cus_info set cus_name=?,cus_gender=?,cus_phone=?,cus_postcode=?,cus_mail=?,cus_address=? where cus_name=?");
	      stmt.setString(1,cus_new_name);
	      stmt.setString(2,cus_gender);
	      stmt.setString(3,cus_phone);
	      stmt.setString(4,cus_postcode);
	      stmt.setString(5,cus_mail);
	      stmt.setString(6,cus_address);
	      stmt.setString(7,cus_old_name);
	      int rs = stmt.executeUpdate();
	      if(rs>0)
	      {
	    	  a = true;
	      }    
	    }catch(Exception ex){
	      ex.printStackTrace();
	    }finally{
	    	try{
	    		conn.close();
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
		return a;
	}
	
	public Vo_cus_info getCusInfoByName(String cus_name) throws Exception{	
		Vo_cus_info vo_cus_info = null;
	    try{
	      //创建SQL语句执行类
	      stmt = conn.prepareStatement("select * from cus_info where cus_name=?");
	      stmt.setString(1,cus_name);
	      ResultSet rs = stmt.executeQuery();
	      vo_cus_info = new Vo_cus_info();
	      while(rs.next())
		    {
	    	  vo_cus_info = new Vo_cus_info();
		    	
	    	  vo_cus_info.setCus_id(rs.getInt("cus_id"));
		    	
	    	  vo_cus_info.setCus_name(rs.getString("cus_name"));

	    	  vo_cus_info.setCus_password(rs.getString("cus_password"));

	    	  vo_cus_info.setCus_gender(rs.getString("cus_gender"));
		    	
	    	  vo_cus_info.setCus_phone(rs.getString("cus_phone"));
		    	
	    	  vo_cus_info.setCus_postcode(rs.getString("cus_postcode"));
		    	
	    	  vo_cus_info.setCus_address(rs.getString("cus_address"));
	    	  
	    	  vo_cus_info.setCus_mail(rs.getString("cus_mail"));
		    	
	    	  vo_cus_info.setCus_register_time(rs.getString("cus_register_time"));
		    	
		    }    
	    }catch(Exception ex){
	      ex.printStackTrace();
	    }finally{
	    	try{
	    		conn.close();
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
	    return vo_cus_info;
	}
	
	public boolean updateAddressByCusName(String cus_name, String cus_address) throws Exception{	
		boolean a = false;
	    try{
	      //创建SQL语句执行类
	      cus_name = new String(cus_name.getBytes("ISO-8859-1"),"UTF-8");
	      stmt = conn.prepareStatement("update cus_info set cus_address=? where cus_name=?");
	      stmt.setString(1,cus_name);
	      stmt.setString(2,cus_address);
	      int rs = stmt.executeUpdate();
	      if(rs>0)
	      {
	    	  a = true;
	      }    
	    }catch(Exception ex){
	      ex.printStackTrace();
	    }finally{
	    	try{
	    		conn.close();
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
		return a;
	}
}
