package net.mobilia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mobilia.dao.MemberDAO;
import net.mobilia.vo.MemberVO;

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
}
