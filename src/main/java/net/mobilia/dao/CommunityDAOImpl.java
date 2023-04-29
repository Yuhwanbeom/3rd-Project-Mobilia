package net.mobilia.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommunityDAOImpl implements CommunityDAO {

	@Autowired
	private SqlSession sqlSession;
	
}
