package net.mobilia.service;


import javax.servlet.http.HttpServletResponse;


import net.mobilia.vo.MailVO;

import net.mobilia.vo.MemberVO;

public interface MemberService {

	void insertMember(MemberVO m);

	MemberVO loginCheck(String m_id);

	MemberVO getMemData(String m_id);

	void updateMember(MemberVO m);

	void delMemData(MemberVO m);

	MemberVO idCheck(String id);

	MemberVO idMember(MemberVO m);
	
	public void sendEmail(MemberVO vo, String div) throws Exception;


	public void find_pwd(HttpServletResponse resp, MemberVO vo) throws Exception;

	
		
	


	MailVO createMailAndChangePassword(String memberEmail, String m_id);

	void mailSend(MailVO mv);

	int searchMember(MemberVO m);

}
