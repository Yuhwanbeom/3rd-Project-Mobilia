package net.mobilia.dao;

import net.mobilia.vo.MemberVO;

public interface MemberDAO {

	void insertMember(MemberVO m);

	MemberVO loginCheck(String m_id);

}
