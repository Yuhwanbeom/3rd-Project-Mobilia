package net.mobilia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mobilia.dao.MemberDAO;
import net.mobilia.vo.MemberVO;
import net.mobilia.vo.OrderVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO mDao;

	@Override
	public void insertMember(MemberVO m) {
		
		this.mDao.insertMember(m);
	}

	@Override
	public MemberVO loginCheck(String m_id) {
		
		return this.mDao.loginCheck(m_id);
	}

	@Override
	public MemberVO getMemData(String m_id) {
		
		return this.mDao.getMemData(m_id);
	}

	@Override
	public void updateMember(MemberVO m) {
	
		this.mDao.updateMember(m);
	}

	@Override
	public void delMemData(MemberVO m) {
		
		this.mDao.delMemData(m);
	}

	@Override
	public MemberVO idCheck(String id) {
		
		return this.mDao.idCheck(id);
	}

	@Override
	public MemberVO idMember(MemberVO m) {
		
		return this.mDao.idMember(m);
	}

	@Override
	public int getOrderCount(OrderVO ovo) {
		
		return this.mDao.getOrderCount(ovo);
	}

	@Override
	public List<OrderVO> getOrderList(OrderVO getovo) {
		
		return this.mDao.getOrderList(getovo);
	}

}
