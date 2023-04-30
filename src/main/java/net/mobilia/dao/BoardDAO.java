package net.mobilia.dao;

import java.util.List;

import net.mobilia.vo.BoardVO;

public interface BoardDAO {

	int getListCount(BoardVO findbvo);

	List<BoardVO> getBoardList(BoardVO findbvo);

	void insertBoard(BoardVO bvo);

}
