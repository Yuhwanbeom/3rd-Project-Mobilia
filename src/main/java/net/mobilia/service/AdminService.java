package net.mobilia.service;

import java.util.List;

import net.mobilia.vo.ProductVO;

public interface AdminService {

	int getListCount(ProductVO pv);
	List<ProductVO> getProductList(ProductVO pv);
}
