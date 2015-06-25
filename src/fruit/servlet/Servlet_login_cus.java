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
		//ʵ�ֵ�¼����
		String cus_name = null;
		String cus_password = null;
		//��ȡ���ݹ���������������
		cus_name = request.getParameter("cus_name");
		cus_password = request.getParameter("cus_password");
		if(cus_name != null && !cus_name.equals("") && cus_password != null && !cus_password.equals(""))
		{
			//�ع��ַ��������������
			cus_name = new String(cus_name.getBytes("ISO-8859-1"),"UTF-8");
			//ȥ���û����Ŀո�
			cus_name = cus_name.trim();
			//���������
			cus_password = MD5.getMD5(cus_password.trim().getBytes());
		}
		
		
		if(cus_name == null || "".equals(cus_name) || cus_password == null || "".equals(cus_password) )
		{
			response.sendRedirect("cus_login.jsp");
		}else
		{		
			//���ù�����ķ�������֤�û���
			try {			
				if(Factory_cus_info.getLoginResult(cus_name, cus_password) == 2)
				{
					//���ݷ������صı�ǣ�����ɹ���ִ�����´���
					HttpSession session=request.getSession(true);
					//���û��������뱣����session��
					session.setAttribute("cus_name",cus_name); 
					session.setAttribute("cus_password",cus_password); 
			    	session.setMaxInactiveInterval(30 * 60);
			    	response.sendRedirect("show.jsp?kind_id=1");

				}else if(Factory_cus_info.getLoginResult(cus_name, cus_password) == 1)
				{
					//���������ִ��
					response.sendRedirect("cus_login.jsp?flag=1");
				}else if(Factory_cus_info.getLoginResult(cus_name, cus_password) == 0)
				{
					//�û�����������ִ��
					response.sendRedirect("cus_login.jsp?flag=0");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
						
	}

}
