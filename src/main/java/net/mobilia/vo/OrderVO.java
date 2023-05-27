package net.mobilia.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderVO {

	private String order_no;
	private String m_id;
	private String order_name;
	private int order_price;
	private int order_state;
	//주문조회에서 처리할 변수
	private String order_check;
}
