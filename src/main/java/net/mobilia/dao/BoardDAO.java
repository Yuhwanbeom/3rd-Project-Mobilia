package net.mobilia.dao;

import java.util.List;

import net.mobilia.vo.BoardVO;

public interface BoardDAO {

	int getListCount(BoardVO findbvo);
	
	void cntUpdate();
	
	List<BoardVO> getBoardList(BoardVO findbvo);

	void insertBoard(BoardVO bvo);

	void updateHit(String board_no);

	BoardVO getBoardCont(String board_no);

	

}
