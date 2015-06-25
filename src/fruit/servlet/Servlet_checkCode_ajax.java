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
		//获取用户输入的验证码
		checkCode = request.getParameter("checkCode");
		//判断验证码是否为空
		if(checkCode != null && !checkCode.equals(""))
		{
			//取得已经生成并存进session的验证码，并判断与用户输入的是否相同
			HttpSession session = request.getSession();
			if(checkCode.equals((String)session.getAttribute("checkCode")))
			{
				//相同则返回true
				out.print("true");
			}else
			{
				//不同则返回false
				out.print("false");
			}
		}else
		{
			//验证码为空则返回null
			out.print("null");
		}
	}

}
