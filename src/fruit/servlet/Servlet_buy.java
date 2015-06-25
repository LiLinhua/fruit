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
		//定义变量接受传过来的值
		int cus_id = 0;
		String cus_name = null;
		String goods_id0 = null;
		String goods_name = null;
		String goods_each_price0 = null;
		String goods_quantity0 = null;
		String cus_address = null;
		//请求session
		HttpSession session = request.getSession();
		//获取用户登录保存的session
		cus_name = (String)session.getAttribute("cus_name");
		try {
			//调用工厂类的通过用户姓名获取用户ID的方法获取用户ID
			cus_id= Factory_cus_info.getCusInfoByName(cus_name).getCus_id();
			//调用工厂类的方法获取用户地址
			cus_address= Factory_cus_info.getCusInfoByName(cus_name).getCus_address();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取传递过来的商品的值
		goods_id0 =request.getParameter("goods_id");
		goods_name = request.getParameter("goods_name");
		goods_each_price0 =request.getParameter("goods_each_price");
		goods_quantity0 = request.getParameter("goods_quantity");
		
		//定义变量保存商品的相关信息
		int goods_id = 0;
		double goods_each_price = 0.0;
		int goods_quantity = 0;
		double goods_total_price = 0.0;
		
		
		if( goods_id0 != null && goods_name != null && goods_each_price0 != null && goods_quantity0 != null)
		{
		//将传递过来的String型的商品信息转为与数据库字段类型相同，方便将信息插入数据库
		goods_id =Integer.parseInt(goods_id0);
		goods_name = request.getParameter("goods_name");
		goods_each_price =Double.parseDouble(goods_each_price0);
		goods_quantity = Integer.parseInt(goods_quantity0);
		goods_total_price = goods_each_price*goods_quantity;
		}
		if(cus_id != 0 && cus_name != null && goods_id != 0 && goods_name != null && goods_each_price != 0.0 && goods_quantity != 0 && goods_total_price != 0.0)
		{
			try {
				//调用工厂类添加订单的方法，将订单信息插进数据库，并根据返回值判断添加订单是否成功
				if(Factory_orderItem_info.addItem(cus_id, cus_name, goods_id, goods_name, goods_each_price, goods_quantity, goods_total_price, cus_address))
				{
					//如果订单添加成功则进行以下跳转，并把相关的商品信息传回去，方便展示给顾客看
					response.sendRedirect("ensureBuyInfo.jsp?changeInfoFlag=true&goods_id="+goods_id+"&goods_name="+goods_name+"&goods_each_price="+goods_each_price+"&goods_quantity="+goods_quantity+"&goods_total_price="+goods_total_price);
				}else
				{
					//如果订单添加失败则进行以下跳转
					response.sendRedirect("ensureBuyInfo.jsp?changeInfoFlag=false&goods_id="+goods_id+"&goods_name="+goods_name+"&goods_each_price="+goods_each_price+"&goods_quantity="+goods_quantity+"&goods_total_price="+goods_total_price);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			//如果传过来的订单信息有空则进行以下跳转
			response.sendRedirect("ensureBuyInfo.jsp?changeInfoFlag=false&goods_id="+goods_id+"&goods_name="+goods_name+"&goods_each_price="+goods_each_price+"&goods_quantity="+goods_quantity+"&goods_total_price="+goods_total_price);
		}
	}

}
