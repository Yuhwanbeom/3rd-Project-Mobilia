package net.mobilia.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.mobilia.vo.MemberVO;
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


	@Override
	public int getMemberCount(MemberVO mv) {
		
		return this.sqlSession.selectOne("ad_m_count",mv);
	}

	@Override
	public List<MemberVO> getMemberList(MemberVO mv) {
		
		return this.sqlSession.selectList("ad_m_list",mv);
	}
	//상품 등록
	@Override
	public int insertProduct(ProductVO pv) {
		return this.sqlSession.insert("ad_p_in",pv);

	}
	@Override
	public ProductVO selectProduct(int p_no) {
		return this.sqlSession.selectOne("ad_p_edit",p_no);
	}
	@Override
	public int updateProduct(ProductVO pv) {
		return this.sqlSession.update("ad_p_update",pv);
	}
}
