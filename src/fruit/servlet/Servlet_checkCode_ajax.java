package fruit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_checkCode_ajax
 */
@WebServlet("/Servlet_checkCode_ajax")
public class Servlet_checkCode_ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_checkCode_ajax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		PrintWriter out = response.getWriter();
		String checkCode = null;
		//��ȡ�û��������֤��
		checkCode = request.getParameter("checkCode");
		//�ж���֤���Ƿ�Ϊ��
		if(checkCode != null && !checkCode.equals(""))
		{
			//ȡ���Ѿ����ɲ����session����֤�룬���ж����û�������Ƿ���ͬ
			HttpSession session = request.getSession();
			if(checkCode.equals((String)session.getAttribute("checkCode")))
			{
				//��ͬ�򷵻�true
				out.print("true");
			}else
			{
				//��ͬ�򷵻�false
				out.print("false");
			}
		}else
		{
			//��֤��Ϊ���򷵻�null
			out.print("null");
		}
	}

}
