package fruit.dao.proxy;

import java.sql.Connection;

import fruit.dao.dbc.DatabaseConnection;

public class Proxy_cart_info {
	java.sql.PreparedStatement stmt = null;
	DatabaseConnection dbc = null;
	Connection conn = null;
	public Proxy_cart_info() throws Exception
	{
		dbc = new DatabaseConnection();
		this.conn = dbc.getConnection();
	}
	
}
