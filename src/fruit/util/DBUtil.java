package fruit.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 数据库操作工具类
public class DBUtil {

	public static int getCount(Connection conn, String sql, Object... params){
		ResultSet rs = null;
		//定义查询操作的结果集
		int rowCount = 0;
		//定义查询操作结果集的总条数
		try {
            //创建会话
            PreparedStatement pstmt =
                    conn.prepareStatement(sql);
            //循环设置参数
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
            //执行数据库查询操作
            if (rs.next()) {
            	rs.last();
            	rowCount = rs.getRow();
                return rowCount;
            }
        //如果有结果，则返回记录条数
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    //返回结果
	}
	public static int getUpdateResult(Connection conn, String sql, Object... params){
		int rs = 0;
		//定义查询操作的结果集
		try {
            //创建会话
            PreparedStatement pstmt =
                    conn.prepareStatement(sql);
            //循环设置参数
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeUpdate();
            //执行数据库查询操作
            if (rs>0) {
                return rs;
            }
        //如果有结果，则返回记录条数
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    //返回结果
	}
	
	
	 public static ResultSet getResultSet(Connection conn,
	            String sql, Object... params) {
	        ResultSet rs = null;
	        //定义查询操作的结果集
	        try {
	            //创建会话
	            PreparedStatement pstmt =
	                    conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
	            //循环设置参数
	            for (int i = 0; i < params.length; i++) {
	                pstmt.setObject(i + 1, params[i]);
	            }
	            rs = pstmt.executeQuery();
	        //执行数据库查询操作
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return rs;
	    //返回结果集
	    }
	 public static void close(Connection conn, Statement stmt,
	            ResultSet rs) {
	        if (rs != null) {
	            try {
	                rs.close();
	            //关闭结果集
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (stmt != null) {
	            try {
	                stmt.close();
	            //关闭会话
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (conn != null) {
	            try {
	                conn.close();
	            //关闭连接
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}

