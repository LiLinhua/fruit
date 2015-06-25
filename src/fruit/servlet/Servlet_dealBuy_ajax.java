package fruit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fruit.dao.factory.Factory_cus_info;
import fruit.dao.factory.Factory_goods_info;
import fruit.dao.factory.Factory_orderItem_info;

/**
 * Servlet implementation class Servlet_dealBuy_ajax
 */
@WebServlet("/Servlet_dealBuy_ajax")
public class Servlet_dealBuy_ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_dealBuy_ajax() {
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
		//添加订单
		PrintWriter out =  response.getWriter();
		int cus_id = 0;
		String cus_name = null;
		String cus_address = null;
		String goods_id = null;
		String goods_name = null;
		String goods_quantity = null;
		double goods_each_price = 0.0;
		double goods_total_price = 0.0;
		
		HttpSession session = request.getSession();
		cus_name = (String)session.getAttribute("cus_name");
		goods_id = request.getParameter("goods_id");
		goods_quantity = request.getParameter("goods_quantity");
		if(goods_id != null && goods_quantity != null)
		{
			try {
				//调用工厂类中的方法获取相关的订单信息
				cus_id = Factory_cus_info.getCusInfoByName(cus_name).getCus_id();
				goods_name = Factory_goods_info.getGoodsInfoByGoodsId(Integer.parseInt(goods_id)).getGoods_name();
				goods_total_price = Integer.parseInt(goods_quantity)*Factory_goods_info.getGoodsInfoByGoodsId(Integer.parseInt(goods_id)).getGoods_price();
				cus_address = Factory_cus_info.getCusInfoByName(cus_name).getCus_name();
				goods_each_price = Factory_goods_info.getGoodsInfoByGoodsId(Integer.parseInt(goods_id)).getGoods_price();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(cus_name != null && goods_id != null && goods_quantity != null)
		{
			
			try {	
				//调用工厂类中的方法添加订单
					if(Factory_orderItem_info.addItem(cus_id, cus_name, Integer.parseInt(goods_id), goods_name, goods_each_price, Integer.parseInt(goods_quantity), goods_total_price, cus_address))
					{
						//订单添加成功则返回true
						out.print("true");
					}else
					{
						//订单添加失败则返回false
						out.print("false");
					}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else
		{
			//如果前端页面传递过来的购买数量等信息为空则返回false
			out.print("false");
		}
		
		
	}

}
