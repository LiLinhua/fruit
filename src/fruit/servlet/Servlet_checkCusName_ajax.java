package fruit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fruit.dao.dbc.DatabaseConnection;

/**
 * Servlet implementation class Servlet_checkCusName_ajax
 */
@WebServlet("/Servlet_checkCusName_ajax")
public class Servlet_checkCusName_ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_checkCusName_ajax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ajax�ж��û����Ƿ����
		PrintWriter out = response.getWriter();
		String cus_name = null;
		cus_name = request.getParameter("cus_name");
		Connection conn = null;
		DatabaseConnection dbc = null;
		java.sql.PreparedStatement stmt = null;
		try {
			
			dbc = new DatabaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ȡ�����ݿ�����
		conn = dbc.getConnection();
		try {
			//��ѯ���ݿ��û����Ƿ����
			stmt = conn.prepareStatement("select cus_name from cus_info where cus_name=?");
			stmt.setString(1,cus_name);
		    ResultSet rs = stmt.executeQuery();
			if(rs.next())
			  {
				//�û������ھͷ���true
				  out.print("true");
			  }else
			  {
				  //�û����������򷵻�false
				  out.print("false"); 
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				//�ر�����
				conn.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	    
		
	}

}
