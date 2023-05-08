package net.mobilia.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.mobilia.vo.BoardVO;
import net.mobilia.vo.ReviewVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int getListCount(BoardVO findbvo) {
		
		return sqlSession.selectOne("board_count", findbvo);
	}//게시물 개수 구하기
	
	@Override
	public int getReviewCount(ReviewVO findrvo) {
		
		return sqlSession.selectOne("review_count", findrvo);
	}//상품후기 개수 구하기
	
	@Override
	public void cntUpdate() {
		
		sqlSession.update("reply_cnt");
	}//댓글 개수 구해서 업데이트 처리
	
	@Override
	public List<BoardVO> getBoardList(BoardVO findbvo) {

		return sqlSession.selectList("board_list", findbvo);
	}//게시물 목록 구하기

	@Override
	public void insertBoard(BoardVO bvo) {
		
		sqlSession.insert("board_insert", bvo);
	}//글쓰기

	@Override
	public void updateHit(String board_no) {
		
		sqlSession.update("update_hit", board_no);
	}//조회수 증가

	@Override
	public BoardVO getBoardCont(String board_no) {
		
		return sqlSession.selectOne("get_cont", board_no);
	}//글내용 가져오기
	
}
