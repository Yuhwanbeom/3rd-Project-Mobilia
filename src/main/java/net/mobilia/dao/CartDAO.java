package net.mobilia.dao;

import java.util.List;

import net.mobilia.vo.CartVO;

public interface CartDAO {

	int addCart(CartVO cvo);

	int getCartData(CartVO cvo);

	void updateCount(CartVO cvo);

	List<CartVO> getCartList(String m_id);

	void delCartData(CartVO cvo);

	void countModifyCart(CartVO cvo);

}
