package fruit.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// ���ݿ����������
public class DBUtil {

	public static int getCount(Connection conn, String sql, Object... params){
		ResultSet rs = null;
		//�����ѯ�����Ľ����
		int rowCount = 0;
		//�����ѯ�����������������
		try {
            //�����Ự
            PreparedStatement pstmt =
                    conn.prepareStatement(sql);
            //ѭ�����ò���
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
            //ִ�����ݿ��ѯ����
            if (rs.next()) {
            	rs.last();
            	rowCount = rs.getRow();
                return rowCount;
            }
        //����н�����򷵻ؼ�¼����
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    //���ؽ��
	}
	public static int getUpdateResult(Connection conn, String sql, Object... params){
		int rs = 0;
		//�����ѯ�����Ľ����
		try {
            //�����Ự
            PreparedStatement pstmt =
                    conn.prepareStatement(sql);
            //ѭ�����ò���
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeUpdate();
            //ִ�����ݿ��ѯ����
            if (rs>0) {
                return rs;
            }
        //����н�����򷵻ؼ�¼����
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    //���ؽ��
	}
	
	
	 public static ResultSet getResultSet(Connection conn,
	            String sql, Object... params) {
	        ResultSet rs = null;
	        //�����ѯ�����Ľ����
	        try {
	            //�����Ự
	            PreparedStatement pstmt =
	                    conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
	            //ѭ�����ò���
	            for (int i = 0; i < params.length; i++) {
	                pstmt.setObject(i + 1, params[i]);
	            }
	            rs = pstmt.executeQuery();
	        //ִ�����ݿ��ѯ����
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return rs;
	    //���ؽ����
	    }
	 public static void close(Connection conn, Statement stmt,
	            ResultSet rs) {
	        if (rs != null) {
	            try {
	                rs.close();
	            //�رս����
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (stmt != null) {
	            try {
	                stmt.close();
	            //�رջỰ
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (conn != null) {
	            try {
	                conn.close();
	            //�ر�����
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}

