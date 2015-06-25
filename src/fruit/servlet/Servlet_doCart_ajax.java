package fruit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fruit.dao.factory.Factory_cartItem_info;
import fruit.dao.factory.Factory_cus_info;
import fruit.dao.factory.Factory_goods_info;
import fruit.dao.factory.Factory_orderItem_info;

/**
 * Servlet implementation class Servlet_doCart_ajax
 */
@WebServlet("/Servlet_doCart_ajax")
public class Servlet_doCart_ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_doCart_ajax() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ʵ�ְ���Ʒ��ӵ����ﳵ�Ĺ���
		PrintWriter out =  response.getWriter();
		String doFlag = null;
		String cartItemId = null;
		String goods_id_str = null;
		String goods_quantity_str = null;
		int cus_id = 0;
		String cus_name = null;
		String cus_address = null;
		String goods_id = null;
		String goods_name = null;
		String goods_quantity = null;
		double goods_each_price = 0.0;
		double goods_total_price = 0.0;
		
		//������ر�����ȡ��ص�ֵ
		HttpSession session = request.getSession();
		doFlag = request.getParameter("doFlag");
		cartItemId = request.getParameter("cartItem_id");
		goods_id_str = request.getParameter("goods_id_str");
		goods_quantity_str = request.getParameter("goods_quantity_str");
		cus_name = (String)session.getAttribute("cus_name");
		goods_id = request.getParameter("goods_id");
		goods_quantity = request.getParameter("goods_quantity");
		
		//�����Ʒid����Ʒ������Ϊ���������תΪ�����ݿ��ֶ�������ͬ������
		if(goods_id != null && goods_quantity != null)
		{
			try {
				cus_id = Factory_cus_info.getCusInfoByName(cus_name).getCus_id();
				goods_name = Factory_goods_info.getGoodsInfoByGoodsId(Integer.parseInt(goods_id)).getGoods_name();
				goods_total_price = Integer.parseInt(goods_quantity)*Factory_goods_info.getGoodsInfoByGoodsId(Integer.parseInt(goods_id)).getGoods_price();
				goods_each_price = Factory_goods_info.getGoodsInfoByGoodsId(Integer.parseInt(goods_id)).getGoods_price();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		//��������Ĳ������Ϊɾ��
		if(doFlag != null && doFlag.equals("deleteCartItem"))
		{
			if(cartItemId != null)
			{
				//ͨ�����ﳵ��idɾ�����ﳵ��Ϣ
					try {
						if(Factory_cartItem_info.deleteItemByItemId(Integer.parseInt(cartItemId)))
						{
							//ɾ���ɹ��򷵻سɹ����deleteTrue
							response.sendRedirect("cart.jsp?addCartFlag=deleteTrue");
						}else
						{
							//ɾ��ʧ���򷵻�ʧ�ܱ��deleteFalse
							response.sendRedirect("cart.jsp?addCartFlag=deleteFalse");
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			}else
			{
				response.sendRedirect("cart.jsp?addCartFlag=deleteFalse");
			}
			out.close();
			
			
		}else if(doFlag != null && doFlag.equals("addCartItem"))//����������ΪaddCartItem��ִ����Ӵ��루һ�����һ�
		{
			if(cus_name != null && goods_id != null && goods_quantity != null )
			{
						try {
							//ִ����ӹ��ﳵ��Ϣ����
							if(Factory_cartItem_info.addItem(cus_id, cus_name, Integer.parseInt(goods_id), goods_name, goods_each_price, Integer.parseInt(goods_quantity), goods_total_price))
							{
								//��ӳɹ��򷵻�right
								out.print("right");
							}else
							{
								//���ʧ���򷵻�wrong
								out.print("wrong");
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		
			}else
			{
				out.print("wrong");
			}
			out.close();
			
			
		}else if(doFlag != null && doFlag.equals("addMuchCartItem"))//����������ΪaddMuchCartItem��ִ����Ӵ��루һ�����һ���
		{
			//�жϴ���������Ʒ��������Ʒid�Ƿ�Ϊ��
			if(goods_quantity_str != null && goods_id_str != null)
			{
				//�ѱ����Ŷ����Ʒid�ĵ��ַ�����ֳ��ַ����飬ȡ��ÿһ����Ʒid
				String goods_id_array[] = goods_id_str.split(",");
				//�ѱ����Ŷ����Ʒ�����ĵ��ַ�����ֳ��ַ����飬ȡ��ÿһ����Ʒ������
				String goods_quantity_array[] = goods_quantity_str.split(",");
				//����int�͵����鱣����Ʒid������
				int goods_id_int[] = new int[goods_id_array.length];
				int goods_quantity_int[] = new int[goods_quantity_array.length];
				//����ɹ���ǣ������ж������Ƿ�ȫ���ɹ�����
				int addFlag = 0;
				for(int i = 0; i<goods_id_int.length; i++)
				{
					//�Ѳ�ֺ��ÿһ���ַ�����Ʒid������ת����int�ͣ���������������
					if(goods_id_int.length>0)
					{
						goods_id_int[i] = Integer.parseInt(goods_id_array[i].trim());
						goods_quantity_int[i] = Integer.parseInt(goods_quantity_array[i].trim());
					}
				}
				for(int j = 0; j<goods_id_int.length; j++)
				{
					//���ù������ȡ������û�����Ʒ��Ϣ�������ڹ��ﳵ����
					try {
						cus_id = Factory_cus_info.getCusInfoByName(cus_name).getCus_id();
						cus_address = Factory_cus_info.getCusInfoByName(cus_name).getCus_address();
						goods_name = Factory_goods_info.getGoodsInfoByGoodsId(goods_id_int[j]).getGoods_name();
						goods_total_price = goods_quantity_int[j]*Factory_goods_info.getGoodsInfoByGoodsId(goods_id_int[j]).getGoods_price();
						goods_each_price = Factory_goods_info.getGoodsInfoByGoodsId(goods_id_int[j]).getGoods_price();
						if(Factory_orderItem_info.addItem(cus_id, cus_name, goods_id_int[j], goods_name, goods_each_price, goods_quantity_int[j], goods_total_price, cus_address))
						{
							//ûÿ�ɹ�����һ��ɹ�����Լ�һ��
							addFlag ++;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(addFlag == goods_id_int.length)
				{
					//ȫ������ɹ��򷵻�all
					out.print("all");
				}else if(addFlag == 0)
				{
					//ȫ������ʧ���򷵻�none
					out.print("none");
				}else
				{
					//���ֲ���ɹ��򷵻�part
					out.print("part");
				}
			}
			out.close();
		}
					
	}

}
