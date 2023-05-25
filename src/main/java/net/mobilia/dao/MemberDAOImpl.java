package net.mobilia.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.mobilia.vo.MemberVO;
import net.mobilia.vo.OrderVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertMember(MemberVO m) {
	
		this.sqlSession.insert("m_in",m);
	}

	@Override
	public MemberVO loginCheck(String m_id) {
	
		return this.sqlSession.selectOne("m_data", m_id);
	}

	@Override
	public MemberVO getMemData(String m_id) {
		
		return this.sqlSession.selectOne("m_data", m_id);
	}

	@Override
	public void updateMember(MemberVO m) {
		
		this.sqlSession.update("m_edit", m);
	}

	@Override
	public void delMemData(MemberVO m) {
		
		this.sqlSession.update("m_del", m);
	}

	@Override
	public MemberVO idCheck(String id) {
		
		return this.sqlSession.selectOne("m_idcheck",id);
	}

	@Override
	public MemberVO idMember(MemberVO m) {
		
		return this.sqlSession.selectOne("get_id", m);
	}

	@Override
	public int getOrderCount(OrderVO ovo) {
		
		return this.sqlSession.selectOne("getOrderCount", ovo);
	}

	@Override
	public List<OrderVO> getOrderList(OrderVO getovo) {
		
		return this.sqlSession.selectList("getOrderList", getovo);
	}
	
}
