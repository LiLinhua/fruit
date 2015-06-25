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
import javax.servlet.http.HttpSession;

import fruit.dao.dbc.DatabaseConnection;

/**
 * Servlet implementation class Servlet_checkRegister_ajax
 */
@WebServlet("/Servlet_updatePersonInfo_ajax")
public class Servlet_updatePersonInfo_ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_updatePersonInfo_ajax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//更新用户信息的servlet
		PrintWriter out = response.getWriter();
		String cus_name = null;
		String cus_phone = null;
		String cus_mail = null;
		String cus_address = null;
		
		cus_name = request.getParameter("cus_name");
		cus_phone = request.getParameter("cus_phone");
		cus_mail = request.getParameter("cus_mail");
		cus_address = request.getParameter("cus_address");
		
		
		
		Connection conn = null;
		DatabaseConnection dbc = null;
		java.sql.PreparedStatement stmt = null;
		HttpSession session = request.getSession();
		String session_cus_name = null;
		session_cus_name = (String)session.getAttribute("cus_name");

		if(cus_name != null && cus_name != "")
		{
			cus_name = new String(cus_name.getBytes("ISO-8859-1"),"UTF-8");
			cus_name = cus_name.trim();
			try {
				dbc = new DatabaseConnection();
				conn = dbc.getConnection();
				stmt = conn.prepareStatement("select cus_name from cus_info where cus_name=?");
				stmt.setString(1,cus_name);
			    ResultSet rs = stmt.executeQuery();
				if(rs.next() && !session_cus_name.equals(cus_name))
				  {
					  
					  out.print("nameTrue");
				  }else
				  {
					  out.print("nameFalse"); 
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try{
					conn.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		if(cus_phone != null && !cus_phone.equals(""))
		{
			try 
			{
				dbc = new DatabaseConnection();
				conn = dbc.getConnection();
				stmt = conn.prepareStatement("select cus_phone from cus_info where cus_name=?");
				stmt.setString(1,session_cus_name);
			    ResultSet rs1 = null;
				rs1 = stmt.executeQuery();
			    String old_phone = null;
				if(rs1.next())
				{
					old_phone = rs1.getString("cus_phone"); 
				}
				cus_phone = cus_phone.trim();
				stmt = conn.prepareStatement("select cus_phone from cus_info where cus_phone=?");
				stmt.setString(1,cus_phone);
			    ResultSet rs = stmt.executeQuery();
				if(rs.next() && !cus_phone.equals(old_phone))
				  {
					  out.print("phoneTrue");
				  }else
				  {
					  out.print("phoneFalse"); 
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try{
					conn.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		 
		if(cus_mail != null && !cus_mail.equals(""))
		{	
			cus_mail = cus_mail.trim();
			try {
				dbc = new DatabaseConnection();
				conn = dbc.getConnection();
				stmt = conn.prepareStatement("select cus_mail from cus_info where cus_name=?");
				stmt.setString(1,session_cus_name);
			    ResultSet rs1 = null;
				rs1 = stmt.executeQuery();
			    String old_mail = null;
				while(rs1.next())
				{
					old_mail = rs1.getString("cus_mail"); 
				}
				stmt = conn.prepareStatement("select cus_mail from cus_info where cus_mail=?");
				stmt.setString(1,cus_mail);
			    ResultSet rs = stmt.executeQuery();
				if(rs.next() && !old_mail.equals(cus_mail))
				  {
					  out.print("mailTrue");
				  }else
				  {
					  out.print("mailFalse"); 
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try{
					conn.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		
		if(cus_address != null && !cus_address.equals(""))
		{	
			session_cus_name = session_cus_name.trim();
			cus_address = new String(cus_address.getBytes("ISO-8859-1"),"UTF-8");
			try {
				dbc = new DatabaseConnection();
				conn = dbc.getConnection();
				stmt = conn.prepareStatement("update cus_info set cus_address=? where cus_name=?");
				stmt.setString(1,cus_address);
				stmt.setString(2,session_cus_name);
			    int rs1 = 0;
				rs1 = stmt.executeUpdate();
				
				if(rs1 > 0)
				{
					out.print("true");
				}else
				{
					out.print("false");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try{
					conn.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

}
