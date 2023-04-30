package net.mobilia.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.mobilia.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int getListCount(BoardVO findbvo) {
		
		return sqlSession.selectOne("board_count",findbvo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO findbvo) {
		
		return sqlSession.selectList("board_list", findbvo);
	}

	@Override
	public void insertBoard(BoardVO bvo) {
		
		sqlSession.insert("board_insert", bvo);
	}
}
