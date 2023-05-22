package net.mobilia.service;

import java.util.List;

import net.mobilia.vo.CartVO;

public interface CartService {

	int addCart(CartVO cvo);

	int getCartData(CartVO cvo);

	void updateCount(CartVO cvo);

	List<CartVO> getCartList(String m_id);

}
