package net.mobilia.dao;

import java.util.List;

import net.mobilia.vo.MemberVO;
import net.mobilia.vo.ProductVO;

public interface AdminDAO {

	int getListCount(ProductVO pv);
	List<ProductVO> getProductList(ProductVO pv);
	int getMemberCount(MemberVO mv);
	List<MemberVO> getMemberList(MemberVO mv);
	int insertProduct(ProductVO pv);
	ProductVO selectProduct(int p_no);
	int updateProduct(ProductVO pv);
}
