package fruit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fruit.dao.factory.Factory_cus_info;
import fruit.dao.factory.Factory_orderItem_info;

/**
 * Servlet implementation class Servlet_buy
 */
@WebServlet("/Servlet_buy")
public class Servlet_buy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_buy() {
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
		//����������ܴ�������ֵ
		int cus_id = 0;
		String cus_name = null;
		String goods_id0 = null;
		String goods_name = null;
		String goods_each_price0 = null;
		String goods_quantity0 = null;
		String cus_address = null;
		//����session
		HttpSession session = request.getSession();
		//��ȡ�û���¼�����session
		cus_name = (String)session.getAttribute("cus_name");
		try {
			//���ù������ͨ���û�������ȡ�û�ID�ķ�����ȡ�û�ID
			cus_id= Factory_cus_info.getCusInfoByName(cus_name).getCus_id();
			//���ù�����ķ�����ȡ�û���ַ
			cus_address= Factory_cus_info.getCusInfoByName(cus_name).getCus_address();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ȡ���ݹ�������Ʒ��ֵ
		goods_id0 =request.getParameter("goods_id");
		goods_name = request.getParameter("goods_name");
		goods_each_price0 =request.getParameter("goods_each_price");
		goods_quantity0 = request.getParameter("goods_quantity");
		
		//�������������Ʒ�������Ϣ
		int goods_id = 0;
		double goods_each_price = 0.0;
		int goods_quantity = 0;
		double goods_total_price = 0.0;
		
		
		if( goods_id0 != null && goods_name != null && goods_each_price0 != null && goods_quantity0 != null)
		{
		//�����ݹ�����String�͵���Ʒ��ϢתΪ�����ݿ��ֶ�������ͬ�����㽫��Ϣ�������ݿ�
		goods_id =Integer.parseInt(goods_id0);
		goods_name = request.getParameter("goods_name");
		goods_each_price =Double.parseDouble(goods_each_price0);
		goods_quantity = Integer.parseInt(goods_quantity0);
		goods_total_price = goods_each_price*goods_quantity;
		}
		if(cus_id != 0 && cus_name != null && goods_id != 0 && goods_name != null && goods_each_price != 0.0 && goods_quantity != 0 && goods_total_price != 0.0)
		{
			try {
				//���ù�������Ӷ����ķ�������������Ϣ������ݿ⣬�����ݷ���ֵ�ж���Ӷ����Ƿ�ɹ�
				if(Factory_orderItem_info.addItem(cus_id, cus_name, goods_id, goods_name, goods_each_price, goods_quantity, goods_total_price, cus_address))
				{
					//���������ӳɹ������������ת��������ص���Ʒ��Ϣ����ȥ������չʾ���˿Ϳ�
					response.sendRedirect("ensureBuyInfo.jsp?changeInfoFlag=true&goods_id="+goods_id+"&goods_name="+goods_name+"&goods_each_price="+goods_each_price+"&goods_quantity="+goods_quantity+"&goods_total_price="+goods_total_price);
				}else
				{
					//����������ʧ�������������ת
					response.sendRedirect("ensureBuyInfo.jsp?changeInfoFlag=false&goods_id="+goods_id+"&goods_name="+goods_name+"&goods_each_price="+goods_each_price+"&goods_quantity="+goods_quantity+"&goods_total_price="+goods_total_price);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			//����������Ķ�����Ϣ�п������������ת
			response.sendRedirect("ensureBuyInfo.jsp?changeInfoFlag=false&goods_id="+goods_id+"&goods_name="+goods_name+"&goods_each_price="+goods_each_price+"&goods_quantity="+goods_quantity+"&goods_total_price="+goods_total_price);
		}
	}

}
