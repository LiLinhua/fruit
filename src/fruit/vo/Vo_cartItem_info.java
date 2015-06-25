package fruit.vo;

public class Vo_cartItem_info {
	private int cartItem_id;
	private int cus_id;
	private int goods_id;
	private int goods_quantity;
	private String cus_name;
	private String goods_name;
	private double goods_each_price;
	private double goods_total_price;
	private String cartItem_time;
	public int getCartItem_id() {
		return cartItem_id;
	}
	public void setCartItem_id(int cartItem_id) {
		this.cartItem_id = cartItem_id;
	}
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getGoods_quantity() {
		return goods_quantity;
	}
	public void setGoods_quantity(int goods_quantity) {
		this.goods_quantity = goods_quantity;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public double getGoods_each_price() {
		return goods_each_price;
	}
	public void setGoods_each_price(double goods_each_price) {
		this.goods_each_price = goods_each_price;
	}
	public double getGoods_total_price() {
		return goods_total_price;
	}
	public void setGoods_total_price(double goods_total_price) {
		this.goods_total_price = goods_total_price;
	}
	public String getCartItem_time() {
		return cartItem_time;
	}
	public void setCartItem_time(String cartItem_time) {
		this.cartItem_time = cartItem_time;
	}
	
}
