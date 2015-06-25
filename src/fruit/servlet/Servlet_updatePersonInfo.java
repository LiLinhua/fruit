package fruit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fruit.dao.factory.*;

/**
 * Servlet implementation class Servlet_updatePersonInfo
 */
@WebServlet("/Servlet_updatePersonInfo")
public class Servlet_updatePersonInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_updatePersonInfo() {
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
		String flag = null;
		flag = request.getParameter("flag");
		
		if(flag != null && flag.equals("changeAll"))
		{
			String cus_old_name = null;
			String cus_name = null;
			String cus_gender = null;
			String cus_phone = null;
			String cus_mail = null;
			String cus_postcode = null;
			String cus_address = null;
			cus_old_name = request.getParameter("cus_old_name");
			cus_name = request.getParameter("cus_name");
			cus_gender = request.getParameter("cus_gender");
			cus_phone = request.getParameter("cus_phone");
			cus_mail = request.getParameter("cus_mail");
			cus_postcode = request.getParameter("cus_postcode");
			cus_address = request.getParameter("cus_address");
			HttpSession session = request.getSession();
			if(cus_old_name != null && cus_name != null && cus_gender != null && cus_address != null)
			{
				
				cus_old_name = new String(cus_old_name.getBytes("ISO-8859-1"),"UTF-8");
				cus_name = new String(cus_name.getBytes("ISO-8859-1"),"UTF-8");
				cus_gender = new String(cus_gender.getBytes("ISO-8859-1"),"UTF-8");
				cus_address = new String(cus_address.getBytes("ISO-8859-1"),"UTF-8");
			}
			try {
				if(Factory_cus_info.updateInfoByCusName(cus_old_name, cus_name, cus_gender, cus_phone, cus_postcode, cus_mail, cus_address))
				{	
					session.setAttribute("cus_name", cus_name);
					response.sendRedirect("person_info.jsp?changeFlag=true");	
				}else
				{
					response.sendRedirect("updatePersonInfo.jsp?changeFlag=false");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(flag != null && flag.equals("changeAddress"))
		{
			HttpSession session = request.getSession();
			String cus_address = null;
			cus_address = request.getParameter("cus_address");
			if(cus_address != null && cus_address.equals(""))
			{
				try {
					if(Factory_cus_info.updateAddressByCusName((String)session.getAttribute("cus_name"), cus_address))
					{	
						response.sendRedirect("changeAddress.jsp?changeFlag=true");	
					}else
					{
						response.sendRedirect("changeAddress.jsp?changeFlag=false");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}else
		{
			response.sendRedirect("show.jsp?kind_id=1");
		}
		
		
		
	}

}
