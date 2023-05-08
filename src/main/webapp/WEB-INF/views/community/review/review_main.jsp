<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp" />
<link rel="stylesheet" type="text/css" href="./css/board/board.css">
<div class="community-board-area">
	<div class="title-area">
		<h2>사용후기</h2>
		<label class="info-text">상품 사용후기를 볼수있는 공간입니다.</label> <input
			type="button" id="write-button" name="write-button" value="글쓰기"
			onclick="location='/community_write?board_type=free';">
		
	</div>
	<div class="community-select-area">
	
	 <a href="#">자주묻는질문</a>
	|
	 
	 <a href="community_main?board_type=review" class="now-board-type">사용후기</a>
	|
	 
	 <a href="#">Q&A</a>
	|
	
	 <a href="community_main?board_type=free">자유게시판</a>
	|
	
	 <a href="#">공지사항</a>
	
	 </div>
	<form method="get" action="/community_main">
	<div class="community-find-area">
	 <select name="find_field">
	  <option value="board_name"
	  <c:if test="${find_field =='m_id'}">${'selected'}</c:if>>작성자</option>
	  <option value="board_title"
	  <c:if test="${find_field =='p_name'}">${'selected'}</c:if>>상품명</option>
	  <option value="board_cont"
	  <c:if test="${find_field =='re_cont'}">${'selected'}</c:if>>내용</option>
	 </select>
	 <input type="search" id="find_name" name="find_name">
	 <input type="submit" id="find_button" value="검색">
	</div>
	</form>
</div>

<jsp:include page="../../include/footer.jsp" />