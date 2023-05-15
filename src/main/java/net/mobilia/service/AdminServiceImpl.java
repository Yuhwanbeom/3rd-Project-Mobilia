package net.mobilia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mobilia.dao.AdminDAO;
import net.mobilia.vo.MemberVO;
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

	public int getMemberCount(MemberVO mv) {
		
		return this.adminDao.getMemberCount(mv);
	}
	@Override
	public List<MemberVO> getMemberList(MemberVO mv) {
		
		return this.adminDao.getMemberList(mv);
	}

	@Override
	public int insertProduct(ProductVO pv) {
		return this.adminDao.insertProduct(pv);
	}
	@Override
	public ProductVO getProduct(int p_no) {
		return this.adminDao.getProduct(p_no);
	}
	@Override
	public int updateProduct(ProductVO pv) {
		return this.adminDao.updateProduct(pv);
	}
	@Override
	public int delProduct(int p_no) {
		return this.adminDao.delProduct(p_no);
	}
}
