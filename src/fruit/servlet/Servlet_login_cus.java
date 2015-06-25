package fruit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fruit.dao.factory.Factory_cus_info;
import fruit.util.MD5;

/**
 * Servlet implementation class Servlet_login_cus
 */
@WebServlet("/Servlet_login_cus")
public class Servlet_login_cus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_login_cus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//实现登录功能
		String cus_name = null;
		String cus_password = null;
		//获取传递过来的姓名、密码
		cus_name = request.getParameter("cus_name");
		cus_password = request.getParameter("cus_password");
		if(cus_name != null && !cus_name.equals("") && cus_password != null && !cus_password.equals(""))
		{
			//重构字符串解决中文乱码
			cus_name = new String(cus_name.getBytes("ISO-8859-1"),"UTF-8");
			//去除用户名的空格
			cus_name = cus_name.trim();
			//给密码加密
			cus_password = MD5.getMD5(cus_password.trim().getBytes());
		}
		
		
		if(cus_name == null || "".equals(cus_name) || cus_password == null || "".equals(cus_password) )
		{
			response.sendRedirect("cus_login.jsp");
		}else
		{		
			//调用工厂类的方法，验证用户名
			try {			
				if(Factory_cus_info.getLoginResult(cus_name, cus_password) == 2)
				{
					//根据方法返回的标记，插入成功则执行以下代码
					HttpSession session=request.getSession(true);
					//把用户名和密码保存在session中
					session.setAttribute("cus_name",cus_name); 
					session.setAttribute("cus_password",cus_password); 
			    	session.setMaxInactiveInterval(30 * 60);
			    	response.sendRedirect("show.jsp?kind_id=1");

				}else if(Factory_cus_info.getLoginResult(cus_name, cus_password) == 1)
				{
					//密码错误则执行
					response.sendRedirect("cus_login.jsp?flag=1");
				}else if(Factory_cus_info.getLoginResult(cus_name, cus_password) == 0)
				{
					//用户名不存在则执行
					response.sendRedirect("cus_login.jsp?flag=0");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
						
	}

}
