package fruit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fruit.dao.factory.Factory_goods_info;

/**
 * Servlet implementation class Servlet_details
 */
@WebServlet("/Servlet_details")
public class Servlet_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_details() {
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
		//ͨ����Ʒid����Ʒ��Ϣ��ѯ������׼����ʾ��ϸ��ҳ����
		String goods_id = null;
		goods_id = request.getParameter("goods_id");
		if(goods_id != null && !goods_id.equals(""))
		{
			try {
				if(Factory_goods_info.getGoodsInfoByGoodsId(Integer.parseInt(goods_id)) != null)
				{
					//ͨ����Ʒid�ܻ�ȡ����Ʒ��Ϣ����ת����Ʒϸ��ҳ����
					response.sendRedirect("details.jsp?goods_id="+goods_id);
				}else
				{
					//ͨ����Ʒid��ȡ������Ϣ����ת����ҳ
					response.sendRedirect("index.jsp");
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
