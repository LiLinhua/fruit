package fruit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fruit.dao.factory.Factory_cus_info;
import fruit.util.MD5;

/**
 * Servlet implementation class Servlet_register_cus
 */
@WebServlet("/Servlet_register_cus")
public class Servlet_register_cus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_register_cus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest------ request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//处理注册的servlet
		String cus_name = null;
		String cus_password = null;
		String cus_gender = null;
		String cus_phone = null;
		String cus_mail = null;
		cus_name = request.getParameter("cus_name");
		cus_password = request.getParameter("cus_password");
		cus_gender = request.getParameter("cus_gender");
		cus_phone = request.getParameter("cus_phone");
		cus_mail = request.getParameter("cus_mail");
		
		if(cus_name != null && !cus_name.equals("") && cus_password != null && !cus_password.equals("") && cus_gender != null && !cus_gender.equals("") && cus_phone != null && !cus_phone.equals("") && cus_mail != null && !cus_mail.equals(""))
		{
			//重构字符串解决中文乱码
			cus_name = new String(cus_name.getBytes("ISO-8859-1"),"UTF-8");
			cus_gender = new String(cus_gender.getBytes("ISO-8859-1"),"UTF-8");
			//去除空格、加密密码
			cus_name = cus_name.trim();
			cus_password = MD5.getMD5(cus_password.trim().getBytes());
			cus_gender = cus_gender.trim();
			cus_phone = cus_phone.trim();
			cus_mail = cus_mail.trim();
		}
		
		if(cus_name == null || "".equals(cus_name) || cus_password == null || "".equals(cus_password) || cus_phone == null || "".equals(cus_phone) || cus_mail == null || "".equals(cus_mail) )
		{
			//有任何一项内容没有填则返回标记flag=0
			response.sendRedirect("cus_register.jsp?flag=0");
		}else
			
		{		
			try {			
				if(Factory_cus_info.getRegisterResult(cus_name, cus_password, cus_gender, cus_phone, cus_mail) == 1)
				{
					
					
					response.sendRedirect("cus_register.jsp?flag=1");
				}else if(Factory_cus_info.getRegisterResult(cus_name, cus_password, cus_gender, cus_phone, cus_mail) == 0)
				{
					response.sendRedirect("cus_register.jsp?flag=0");
				}else
				{
					response.sendRedirect("cus_register.jsp?flag=2");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
