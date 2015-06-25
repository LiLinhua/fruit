package fruit.vo;

public class Vo_orderItem_info {
	private int orderItem_id;
	private int cus_id;
	private int goods_id;
	private int goods_quantity;
	private String cus_name;
	private String goods_name;
	private double goods_each_price;
	private double goods_total_price;
	private String cus_address;
	private String orderItem_time;
	private String orderItem_state;

	public String getOrderItem_state() {
		return orderItem_state;
	}
	public void setOrderItem_state(String orderItem_state) {
		this.orderItem_state = orderItem_state;
	}
	public int getOrderItem_id() {
		return orderItem_id;
	}
	public void setOrderItem_id(int orderItem_id) {
		this.orderItem_id = orderItem_id;
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
	public String getOrderItem_time() {
		return orderItem_time;
	}
	public void setOrderItem_time(String orderItem_time) {
		this.orderItem_time = orderItem_time;
	}
	public String getCus_address() {
		return cus_address;
	}
	public void setCus_address(String cus_address) {
		this.cus_address = cus_address;
	}	
}
