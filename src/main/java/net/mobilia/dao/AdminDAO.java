package net.mobilia.dao;

import java.util.List;

import net.mobilia.vo.ProductVO;

public interface AdminDAO {

	int getListCount(ProductVO pv);
	List<ProductVO> getProductList(ProductVO pv);
	int insertProduct(ProductVO pv);
}
