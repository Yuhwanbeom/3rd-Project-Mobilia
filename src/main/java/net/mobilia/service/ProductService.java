package net.mobilia.service;

import java.util.List;

import net.mobilia.vo.ProductVO;

public interface ProductService {

	List<ProductVO> getNewItem(ProductVO pv);
	List<ProductVO> getMdChoice(ProductVO pv);
	int getListCount(ProductVO pv);
	List<ProductVO> getProductList(ProductVO pv);
	int getListCount2(ProductVO pv);
	List<ProductVO> getProductList2(ProductVO pv);
	List<ProductVO> getProductListMod(ProductVO pv);
	List<ProductVO> getProductListMod2(ProductVO pv);
}
