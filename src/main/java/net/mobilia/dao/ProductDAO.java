package net.mobilia.dao;

import java.util.List;

import net.mobilia.vo.ProductVO;

public interface ProductDAO {

	List<ProductVO> getNewItem(ProductVO pv);
	List<ProductVO> getMdChoice(ProductVO pv);
}
