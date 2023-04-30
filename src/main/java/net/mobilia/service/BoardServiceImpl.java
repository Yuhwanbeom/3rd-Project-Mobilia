package net.mobilia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
