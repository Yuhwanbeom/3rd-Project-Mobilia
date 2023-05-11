package net.mobilia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mobilia.dao.AdminDAO;
import net.mobilia.vo.ProductVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDao;
	
	@Override
	public int getListCount(ProductVO pv) {
		return this.adminDao.getListCount(pv);
	}
	@Override
	public List<ProductVO> getProductList(ProductVO pv) {
		return this.adminDao.getProductList(pv);
	}
	@Override
	public int insertProduct(ProductVO pv) {
		return this.adminDao.insertProduct(pv);
	}
}
