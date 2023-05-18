package net.mobilia.service;

import java.util.List;

import net.mobilia.vo.MemberVO;
import net.mobilia.vo.ProductVO;

public interface AdminService {

	int getListCount(ProductVO pv);
	List<ProductVO> getProductList(ProductVO pv);
	int getMemberCount(MemberVO mv);
	List<MemberVO> getMemberList(MemberVO mv);
	int insertProduct(ProductVO pv);
	ProductVO getProduct(int p_no);
	int updateProduct(ProductVO pv);
	int delProduct(int p_no);
	int getMember(String m_id);
	void delMember(MemberVO m);
}
