package net.mobilia.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.mobilia.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private String namespace;

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
	public void updatePassword(MemberVO mv) {
		this.sqlSession.update("m_updatePassword",mv);
	}

	@Override
	public int searchMember(MemberVO m) {
		return this.sqlSession.selectOne("search_m",m);
	}

	
}
