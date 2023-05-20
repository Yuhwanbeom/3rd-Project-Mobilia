package net.mobilia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mobilia.dao.CartDAO;
import net.mobilia.vo.CartVO;

@Service
public class CartServiceImpl implements CartService {

	@Autowired CartDAO cartDao;

	@Override
	public int addCart(CartVO cvo) {
		
		return cartDao.addCart(cvo);
	}

	@Override
	public int getCartData(CartVO cvo) {
		
		return cartDao.getCartData(cvo);
	}

	@Override
	public void updateCount(CartVO cvo) {
		
		cartDao.updateCount(cvo);
	}

	@Override
	public List<CartVO> getCartList(String m_id) {
		
		return cartDao.getCartList(m_id);
	}

	@Override
	public void delCartData(CartVO cvo) {
		
		cartDao.delCartData(cvo);
	}
}
