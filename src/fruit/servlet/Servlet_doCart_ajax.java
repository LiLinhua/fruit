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
		//实现把商品添加到购物车的功能
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
		
		//定义相关变量获取相关的值
		HttpSession session = request.getSession();
		doFlag = request.getParameter("doFlag");
		cartItemId = request.getParameter("cartItem_id");
		goods_id_str = request.getParameter("goods_id_str");
		goods_quantity_str = request.getParameter("goods_quantity_str");
		cus_name = (String)session.getAttribute("cus_name");
		goods_id = request.getParameter("goods_id");
		goods_quantity = request.getParameter("goods_quantity");
		
		//如果商品id和商品质量不为空则把它们转为与数据库字段类型相同的类型
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
		//如果传来的操作标记为删除
		if(doFlag != null && doFlag.equals("deleteCartItem"))
		{
			if(cartItemId != null)
			{
				//通过购物车项id删除购物车信息
					try {
						if(Factory_cartItem_info.deleteItemByItemId(Integer.parseInt(cartItemId)))
						{
							//删除成功则返回成功标记deleteTrue
							response.sendRedirect("cart.jsp?addCartFlag=deleteTrue");
						}else
						{
							//删除失败则返回失败标记deleteFalse
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
			
			
		}else if(doFlag != null && doFlag.equals("addCartItem"))//如果操作标记为addCartItem则执行添加代码（一次添加一项）
		{
			if(cus_name != null && goods_id != null && goods_quantity != null )
			{
						try {
							//执行添加购物车信息代码
							if(Factory_cartItem_info.addItem(cus_id, cus_name, Integer.parseInt(goods_id), goods_name, goods_each_price, Integer.parseInt(goods_quantity), goods_total_price))
							{
								//添加成功则返回right
								out.print("right");
							}else
							{
								//添加失败则返回wrong
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
			
			
		}else if(doFlag != null && doFlag.equals("addMuchCartItem"))//如果操作标记为addMuchCartItem则执行添加代码（一次添加一多项）
		{
			//判断传过来的商品数量和商品id是否为空
			if(goods_quantity_str != null && goods_id_str != null)
			{
				//把保存着多个商品id的的字符串拆分成字符数组，取出每一个商品id
				String goods_id_array[] = goods_id_str.split(",");
				//把保存着多个商品数量的的字符串拆分成字符数组，取出每一个商品的数量
				String goods_quantity_array[] = goods_quantity_str.split(",");
				//定义int型的数组保存商品id，数量
				int goods_id_int[] = new int[goods_id_array.length];
				int goods_quantity_int[] = new int[goods_quantity_array.length];
				//定义成功标记，用于判断数据是否全部成功插入
				int addFlag = 0;
				for(int i = 0; i<goods_id_int.length; i++)
				{
					//把拆分后的每一个字符型商品id、数量转换成int型，并保存在数组中
					if(goods_id_int.length>0)
					{
						goods_id_int[i] = Integer.parseInt(goods_id_array[i].trim());
						goods_quantity_int[i] = Integer.parseInt(goods_quantity_array[i].trim());
					}
				}
				for(int j = 0; j<goods_id_int.length; j++)
				{
					//调用工厂类获取更多的用户、商品信息，保存在购物车表中
					try {
						cus_id = Factory_cus_info.getCusInfoByName(cus_name).getCus_id();
						cus_address = Factory_cus_info.getCusInfoByName(cus_name).getCus_address();
						goods_name = Factory_goods_info.getGoodsInfoByGoodsId(goods_id_int[j]).getGoods_name();
						goods_total_price = goods_quantity_int[j]*Factory_goods_info.getGoodsInfoByGoodsId(goods_id_int[j]).getGoods_price();
						goods_each_price = Factory_goods_info.getGoodsInfoByGoodsId(goods_id_int[j]).getGoods_price();
						if(Factory_orderItem_info.addItem(cus_id, cus_name, goods_id_int[j], goods_name, goods_each_price, goods_quantity_int[j], goods_total_price, cus_address))
						{
							//没每成功插入一项，成功标记自加一次
							addFlag ++;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(addFlag == goods_id_int.length)
				{
					//全部插入成功则返回all
					out.print("all");
				}else if(addFlag == 0)
				{
					//全部插入失败则返回none
					out.print("none");
				}else
				{
					//部分插入成功则返回part
					out.print("part");
				}
			}
			out.close();
		}
					
	}

}
