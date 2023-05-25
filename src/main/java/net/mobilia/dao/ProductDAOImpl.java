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
	}//메인 NewItem 상품 불러오기

	@Override
	public List<ProductVO> getMdChoice(ProductVO pv) {
		return sqlSession.selectList("list_md",pv);
	}//메인 Md's Choice 상품 불러오기

	@Override
	public int getListCount(ProductVO pv) {
		return sqlSession.selectOne("list_count",pv);
	}//상품리스트창 상품 개수

	@Override
	public List<ProductVO> getProductList(ProductVO pv) {
		return sqlSession.selectList("p_list",pv);
	}//상품리스트창 상품

	@Override
	public int getListCount2(ProductVO pv) {
		return sqlSession.selectOne("list_count2",pv);
	}//카테고리 선택 상품 개수

	@Override
	public List<ProductVO> getProductList2(ProductVO pv) {
		return sqlSession.selectList("p_list2",pv);
	}//카테고리 선택 상품

	@Override
	public List<ProductVO> getProductListMod(ProductVO pv) {
		return sqlSession.selectList("p_list_m",pv);
	}//정렬순서 선택 상품 

	@Override
	public List<ProductVO> getProductListMod2(ProductVO pv) {
		return sqlSession.selectList("p_list_m2",pv);
	}//카테고리+정렬순서 선택 상품

	@Override
	public ProductVO getProductInfo(int p_no) {
		return sqlSession.selectOne("p_info", p_no);
	}//상품정보

	@Override
	public int getReviewCount(int p_no) {
		return sqlSession.selectOne("r_count",p_no);
	}//리뷰 개수

	@Override
	public List<ReviewVO> getReviewList(ReviewVO rv) {
		return sqlSession.selectList("r_list",rv);
	}//리뷰 목록

	@Override
	public int insertReview(ReviewVO rv) {
		return sqlSession.insert("r_in",rv);
	}//리뷰 저장

	@Override
	public ReviewVO getReviewCont(int re_no) {
		return sqlSession.selectOne("r_info",re_no);
	}//리뷰 정보

	@Override
	public int updateReview(ReviewVO rv) {
		return sqlSession.update("r_edit",rv);
	}//리뷰 수정

	@Override
	public int delReview(int re_no) {
		return sqlSession.delete("r_del",re_no);
	}//리뷰 삭제

	@Override
	public List<ProductVO> searchProductList(ProductVO pvo) {
		return sqlSession.selectList("s_list", pvo);
	}//검색한 상품 찾기

	@Override
	public List<ProductVO> getBestSeller(ProductVO pv) {
		return sqlSession.selectList("list_best",pv);
	}//메인 BestSeller 상품 불러오기
}
