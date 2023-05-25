package net.mobilia.dao;

import java.util.List;

import net.mobilia.vo.ProductVO;
import net.mobilia.vo.ReviewVO;

public interface ProductDAO {

	List<ProductVO> getNewItem(ProductVO pv);
	List<ProductVO> getMdChoice(ProductVO pv);
	int getListCount(ProductVO pv);
	List<ProductVO> getProductList(ProductVO pv);
	int getListCount2(ProductVO pv);
	List<ProductVO> getProductList2(ProductVO pv);
	List<ProductVO> getProductListMod(ProductVO pv);
	List<ProductVO> getProductListMod2(ProductVO pv);
	ProductVO getProductInfo(int p_no);
	int getReviewCount(int p_no);
	List<ReviewVO> getReviewList(ReviewVO rv);
	int insertReview(ReviewVO rv);
	ReviewVO getReviewCont(int re_no);
	int updateReview(ReviewVO rv);
	int delReview(int re_no);
	List<ProductVO> searchProductList(ProductVO pvo);
	List<ProductVO> getBestSeller(ProductVO pv);
}
