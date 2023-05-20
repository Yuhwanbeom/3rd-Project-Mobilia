package net.mobilia.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.mobilia.vo.CartVO;

@Repository
public class CartDAOImpl implements CartDAO {

	@Autowired SqlSession sqlSession;

	@Override
	public int addCart(CartVO cvo) {
		
		return sqlSession.insert("addCart", cvo);
	}

	@Override
	public int getCartData(CartVO cvo) {
		
		return sqlSession.selectOne("getCartData", cvo);
	}

	@Override
	public void updateCount(CartVO cvo) {
		
		sqlSession.update("updateCount", cvo);
	}

	@Override
	public List<CartVO> getCartList(String m_id) {
		
		return sqlSession.selectList("getCartList", m_id);
	}

	@Override
	public void delCartData(CartVO cvo) {
		
		sqlSession.delete("delCartData", cvo);
	}
}
