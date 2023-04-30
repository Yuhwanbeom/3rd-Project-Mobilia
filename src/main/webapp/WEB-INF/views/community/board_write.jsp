<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

<script src="./js/board/board_write.js"></script>

<link rel="stylesheet" type="text/css" href="./css/board/board_write.css">
<div id="board-wrap">
<div class="title-area">
	<h2>Community</h2>
	<label class="write-info-text">Community 게시글을 작성하는 공간입니다.</label>
	<hr>
</div>
<form name="b" method="post" action="/community_write_ok">
	<div class="board-write-area">
	<input type="hidden" id="board_state" name="board_state" value="free-board">	
			<table>
				<tr>
					<th>글쓴이</th>
					<td><label>${id}</label></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input id="board_title" name="board_title"></td>
				</tr>
				<tr>
					<th colspan="2">
					<textarea name="board_cont" id="board_cont" ></textarea>
					</th>
				</tr>
				</table>
	</div>
	<div class="write-button-area">
	 <input type=submit id="write-submit-button" value="게시글등록">
	 <input type="reset" id="write-list-button" value="게시글목록" onclick="location='/community_main';">
	</div>
</form>
</div>
<jsp:include page="../include/footer.jsp" />