package net.mobilia.dao;

import org.springframework.transaction.annotation.Transactional;

import net.mobilia.vo.MemberVO;

public interface MemberDAO {

	void insertMember(MemberVO m);

	MemberVO loginCheck(String m_id);

	MemberVO getMemData(String m_id);

	void updateMember(MemberVO m);

	void delMemData(MemberVO m);

	MemberVO idCheck(String id);

	MemberVO idMember(MemberVO m);
	
	public int updatePw(MemberVO vo) throws Exception;

	int updatePwd(MemberVO vo) throws Exception;

	MemberVO readMember(String m_id);
}
