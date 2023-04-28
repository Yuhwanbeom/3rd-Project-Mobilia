package net.mobilia.service;

import org.springframework.stereotype.Service;

import net.mobilia.dao.MemberDAO;
import net.mobilia.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberDAO mDao;

	@Override
	public void insertMember(MemberVO m) {
		
		this.mDao.insertMember(m);
		
	}
}
