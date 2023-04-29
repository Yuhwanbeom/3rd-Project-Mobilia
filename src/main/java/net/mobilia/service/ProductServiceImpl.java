package net.mobilia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mobilia.dao.ProductDAO;
import net.mobilia.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDao;

	@Override
	public List<ProductVO> getNewItem(ProductVO pv) {
		return productDao.getNewItem(pv);
	}

	@Override
	public List<ProductVO> getMdChoice(ProductVO pv) {
		return productDao.getMdChoice(pv);
	}
}
