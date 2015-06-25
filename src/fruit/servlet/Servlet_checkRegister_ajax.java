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
 * Servlet implementation class Servlet_checkRegister_ajax
 */
@WebServlet("/Servlet_checkRegister_ajax")
public class Servlet_checkRegister_ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_checkRegister_ajax() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		//处理注册，用户名、电话、邮箱重复问题
		
		PrintWriter out = response.getWriter();
		String cus_name = null;
		String cus_phone = null;
		String cus_mail = null;
		//接受用户注册时传过来的用户名、电话、邮箱
		cus_name = request.getParameter("cus_name");
		cus_phone = request.getParameter("cus_phone");
		cus_mail = request.getParameter("cus_mail");
		Connection conn = null;
		DatabaseConnection dbc = null;
		java.sql.PreparedStatement stmt = null;
		
		try {
			dbc = new DatabaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//取得数据库连接
		conn = dbc.getConnection();
		if(cus_name != null && cus_name != "")
		{
			//重构字符串解决中文乱码问题
			cus_name = new String(cus_name.getBytes("ISO-8859-1"),"UTF-8");
			//把用户名包含的空格去掉
			cus_name = cus_name.trim();
			try {
				//查询数据库
				stmt = conn.prepareStatement("select cus_name from cus_info where cus_name=?");
				stmt.setString(1,cus_name);
			    ResultSet rs = stmt.executeQuery();
				if(rs.next())
				  {
					//用户名已经存在则返回nameTrue
					  out.print("nameTrue");
				  }else
				  {
					//用户名不存在则返回nameFalse
					  out.print("nameFalse"); 
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try{
					//关闭数据库连接，释放资源
					conn.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		if(cus_phone != null && !cus_phone.equals(""))
		{
			//把手机号码中包含的空格去掉
			cus_phone = cus_phone.trim();
			try {
				stmt = conn.prepareStatement("select cus_phone from cus_info where cus_phone=?");
				stmt.setString(1,cus_phone);
			    ResultSet rs = stmt.executeQuery();
				if(rs.next())
				  {
					  out.print("phoneTrue");
				  }else
				  {
					  out.print("phoneFalse"); 
				  }
			} catch (SQLException e) {
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
				stmt = conn.prepareStatement("select cus_mail from cus_info where cus_mail=?");
				stmt.setString(1,cus_mail);
			    ResultSet rs = stmt.executeQuery();
				if(rs.next())
				  {
					  out.print("mailTrue");
				  }else
				  {
					  out.print("mailFalse"); 
				  }
			} catch (SQLException e) {
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
