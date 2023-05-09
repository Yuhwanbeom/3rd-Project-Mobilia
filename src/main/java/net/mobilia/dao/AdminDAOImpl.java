package net.mobilia.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.mobilia.vo.ProductVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int getListCount(ProductVO pv) {
		return this.sqlSession.selectOne("ad_p_count",pv);
	}

	@Override
	public List<ProductVO> getProductList(ProductVO pv) {
		return this.sqlSession.selectList("ad_p_list",pv);
	}
}
