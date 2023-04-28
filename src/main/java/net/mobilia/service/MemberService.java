package net.mobilia.service;

import net.mobilia.vo.MemberVO;

public interface MemberService {

	void insertMember(MemberVO m);

	MemberVO loginCheck(String m_id);

	MemberVO getMemData(String m_id);

	void updateMember(MemberVO m);

	void delMemData(MemberVO m);

}
