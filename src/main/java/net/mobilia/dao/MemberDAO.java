package net.mobilia.dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import net.mobilia.vo.MemberVO;
import net.mobilia.vo.OrderVO;

public interface MemberDAO {

	void insertMember(MemberVO m);

	MemberVO loginCheck(String m_id);

	MemberVO getMemData(String m_id);

	void updateMember(MemberVO m);

	void delMemData(MemberVO m);

	MemberVO idCheck(String id);

	MemberVO idMember(MemberVO m);
	

	void updatePassword(MemberVO mv);

	int searchMember(MemberVO m);
	
	int getOrderCount(OrderVO ovo);

	List<OrderVO> getOrderList(OrderVO getovo);


}
