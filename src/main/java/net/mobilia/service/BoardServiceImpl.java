package net.mobilia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import net.mobilia.dao.BoardDAO;
import net.mobilia.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO bDao;

	@Override
	public int getListCount(BoardVO findbvo) {
		
		return bDao.getListCount(findbvo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO findbvo) {
		
		return bDao.getBoardList(findbvo);
	}

	@Override
	public void insertBoard(BoardVO bvo) {
		
		bDao.insertBoard(bvo);
	}

	// 스프링 aop를 통한 트랜잭션 적용대상
	@Transactional(isolation=Isolation.READ_COMMITTED)
	@Override
	public BoardVO getBoardCont(String board_no) {
		
		bDao.updateHit(board_no);
		return bDao.getBoardCont(board_no);
	}
	
}
