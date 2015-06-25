package fruit.vo;

public class Vo_comment_info {
	private int comment_id;
	private int cus_id;
	private int goods_id;
	private int goods_score;
	private String comment_tittle;
	private String comment_content;
	private String cus_name;
	private String comment_time;
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
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
	public int getGoods_score() {
		return goods_score;
	}
	public void setGoods_score(int goods_score) {
		this.goods_score = goods_score;
	}
	public String getComment_tittle() {
		return comment_tittle;
	}
	public void setComment_tittle(String comment_tittle) {
		this.comment_tittle = comment_tittle;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public String getComment_time() {
		return comment_time;
	}
	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}
	
}
