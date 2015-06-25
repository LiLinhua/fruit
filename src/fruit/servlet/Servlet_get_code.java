package fruit.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_get_code
 */
@WebServlet("/Servlet_get_code")
public class Servlet_get_code extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_get_code() {
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
		//获取验证码
		//设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		String method = null;
		method = request.getParameter("method");
		HttpSession session = request.getSession();
		if(session.getAttribute("checkCode") != null)
		{
			session.setAttribute("checkCode", "");
			
		}
		
		if(method != null && method.equals("getCode"))
		{
			
			BufferedImage image = CreateCode.getImag();
			String checkCode = CreateCode.getCode();
			session.setAttribute("checkCode", checkCode);	//将验证码保存到session中，便于以后验证
			System.out.println((String)session.getAttribute("checkCode"));
			try {
				//发送图片
				ImageIO.write(image, "JPEG", response.getOutputStream());
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}

}
