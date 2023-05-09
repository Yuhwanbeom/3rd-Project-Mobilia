package net.mobilia.service;

import java.util.List;

import net.mobilia.vo.BoardVO;
import net.mobilia.vo.ReviewVO;

public interface BoardService {

	int getListCount(BoardVO findbvo);
	
	int getReviewCount(ReviewVO findrvo);

	List<BoardVO> getBoardList(BoardVO findbvo);

	void insertBoard(BoardVO bvo);

	BoardVO getBoardCont(String board_no);

}
