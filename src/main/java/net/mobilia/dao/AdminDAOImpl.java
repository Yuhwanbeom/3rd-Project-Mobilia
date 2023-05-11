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
	
	//상품리스트 개수
	@Override
	public int getListCount(ProductVO pv) {
		return this.sqlSession.selectOne("ad_p_count",pv);
	}
	//상품리스트 목록
	@Override
	public List<ProductVO> getProductList(ProductVO pv) {
		return this.sqlSession.selectList("ad_p_list",pv);
	}
	//상품 등록
	@Override
	public int insertProduct(ProductVO pv) {
		return this.sqlSession.insert("ad_p_in",pv);
	}
}
