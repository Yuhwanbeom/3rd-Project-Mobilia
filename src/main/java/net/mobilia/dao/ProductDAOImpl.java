package net.mobilia.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.mobilia.vo.ProductVO;
import net.mobilia.vo.ReviewVO;

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

	@Override
	public int getListCount(ProductVO pv) {
		return sqlSession.selectOne("list_count",pv);
	}

	@Override
	public List<ProductVO> getProductList(ProductVO pv) {
		return sqlSession.selectList("p_list",pv);
	}

	@Override
	public int getListCount2(ProductVO pv) {
		return sqlSession.selectOne("list_count2",pv);
	}

	@Override
	public List<ProductVO> getProductList2(ProductVO pv) {
		return sqlSession.selectList("p_list2",pv);
	}

	@Override
	public List<ProductVO> getProductListMod(ProductVO pv) {
		return sqlSession.selectList("p_list_m",pv);
	}

	@Override
	public List<ProductVO> getProductListMod2(ProductVO pv) {
		return sqlSession.selectList("p_list_m2",pv);
	}

	@Override
	public ProductVO getProductInfo(int p_no) {
		return sqlSession.selectOne("p_info", p_no);
	}

	@Override
	public int getReviewCount(int p_no) {
		return sqlSession.selectOne("r_count",p_no);
	}

	@Override
	public List<ReviewVO> getReviewList(ReviewVO rv) {
		return sqlSession.selectList("r_list",rv);
	}
}
