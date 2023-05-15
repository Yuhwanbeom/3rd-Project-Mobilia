<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp" />
<link rel="stylesheet" type="text/css" href="./css/board/board.css">
<script src="/js/board/board_main.js"></script>
<div class="community-board-area">
	<div class="title-area">
		<h2>Q&A</h2>
		<label class="info-text">Q&A에 작성된 게시글을 볼수있는 공간입니다.</label> <input
			type="button" id="write-button" name="write-button" value="글쓰기"
			onclick="location='/community_write?board_type=qna';">
	</div>
	<div class="community-select-area">
	
	 <a href="community_main?board_type=question">자주묻는질문</a>
	|
	 
	 <a href="community_main?board_type=review">사용후기</a>
	|
	 
	 <a href="community_main?board_type=qna" class="now-board-type">Q&A</a>
	|
	
	 <a href="community_main?board_type=free">자유게시판</a>
	|
	
	 <a href="#">공지사항</a>
	
	 </div>
	<form method="get" action="/community_main">
	<div class="community-find-area">
	 <select name="find_field">
	  <option value="board_name"
	  <c:if test="${find_field =='board_name'}">${'selected'}</c:if>>작성자</option>
	  <option value="board_title"
	  <c:if test="${find_field =='board_title'}">${'selected'}</c:if>>제목</option>
	 </select>
	 <input type="search" id="find_name" name="find_name">
	 <input type="submit" id="find_button" value="검색">
	</div>
	</form>
<c:if test="${!empty blist}">
 <c:forEach var="b" items="${blist}">
	<div class="write-list-area">
		<div id="board-title-area">
			<label><a href="/community_pwdcheck?board_no=${b.board_no}&board_type=qna">${b.board_title}</a></label>
			<img src="./images/board/re.png" width="35px" height="25px">
			<img src="./images/board/lock.png" width="45px" height="25px"><br>
		</div>
		<div id="board-data-area">
			<label>${b.board_name}</label> | <label>${b.board_date.substring(0,10)}</label> | <label>조회수 ${b.board_hit}</label>
		</div>
	</div>
 </c:forEach>
</c:if>

</div>


<jsp:include page="../../include/footer.jsp" />