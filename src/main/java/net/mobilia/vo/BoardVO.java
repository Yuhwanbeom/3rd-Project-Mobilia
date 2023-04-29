package net.mobilia.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {

	private int board_no; //게시판 번호
	private String board_name; //게시판 이름
	private String board_title; //게시판 제목
	private String board_cont; //게시판 내용
	private int board_hit; //조회수
	private int reply_hit; //댓글개수
	private String board_date; //등록날짜
	private int board_update; //수정 여부 0이면 수정안됨 1이상이면 수정됨
	private String update_date; //수정 날짜
	
	//페이징 관련변수
	private int startrow;//시작 번호
	private int endrow;//끝 번호
	
	//검색 기능 관련변수
	private String find_field; //검색필드
	private String find_name; //검색어
}
