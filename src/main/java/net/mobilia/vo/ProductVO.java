package net.mobilia.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductVO {

	private int p_no;
	private String p_name;
	private int p_before_price;
	private int p_price;
	private int p_amount;
	private int p_sold;
	private String p_img1;
	private String p_img2;
	private int p_choice;
	private String p_class;
	private String p_category;
	private String p_date;
	private String p_info;
	private String p_color;
	private String p_size;
	
	
	private int p_rate; //할인률
}
