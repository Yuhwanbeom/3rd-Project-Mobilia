package net.mobilia.service;

import java.util.List;

import net.mobilia.vo.ProductVO;

public interface ProductService {

	List<ProductVO> getNewItem(ProductVO pv);
	List<ProductVO> getMdChoice(ProductVO pv);
}
