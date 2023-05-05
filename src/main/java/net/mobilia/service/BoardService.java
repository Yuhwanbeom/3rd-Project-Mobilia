package net.mobilia.service;

import java.util.List;

import net.mobilia.vo.BoardVO;

public interface BoardService {

	int getListCount(BoardVO findbvo);

	List<BoardVO> getBoardList(BoardVO findbvo);

	void insertBoard(BoardVO bvo);

	BoardVO getBoardCont(String board_no);

}
