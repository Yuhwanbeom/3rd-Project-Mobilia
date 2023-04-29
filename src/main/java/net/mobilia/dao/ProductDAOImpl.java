package net.mobilia.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.mobilia.vo.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ProductVO> getNewItem(ProductVO pv) {
		return sqlSession.selectList("list_new",pv);
	}

	@Override
	public List<ProductVO> getMdChoice(ProductVO pv) {
		return sqlSession.selectList("list_md",pv);
	}
}
