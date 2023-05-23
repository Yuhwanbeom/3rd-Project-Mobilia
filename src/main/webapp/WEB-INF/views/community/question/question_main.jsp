<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp" />
<link rel="stylesheet" type="text/css" href="./css/board/board.css">

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<script src="./js/board/board_main.js"></script>

<div class="community-board-area">
	<div class="title-area">
		<h2>자주묻는질문</h2>
		<label class="info-te">자주묻는 질문에 관한 답변을 볼수있는 공간입니다.</label>
			
		
	</div>
	<div class="community-select-area">
	
	 <a href="community_main?board_type=question" class="now-board-type">자주묻는질문</a>
	|
	 
	 <a href="community_main?board_type=review">사용후기</a>
	|
	 
	 <a href="community_main?board_type=qna">Q&A</a>
	|
	
	 <a href="community_main?board_type=free">자유게시판</a>
	|
	
	 <a href="#">공지사항</a>
	
	 </div>
	 
	 <div class="wrapper center-block">
     <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
         
        <!-- 첫번째 아이템 -->
        
         <c:if test="${!empty blist}">
 <c:forEach var="b" items="${blist}">
          <div class="panel panel-default">
    <div class="panel-heading active" role="tab" id="${b.board_title}">
     <h4 class="panel-title">
          <a role="button" data-toggle="collapse" data-parent="#accordion" href="#${b.board_cont}" aria-expanded="true" aria-controls="${b.board_cont}">
            
              ${b.board_title}
            </a>
           </h4>
          </div>
           <div id="${b.board_cont}" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="${b.board_title}">
          <div class="panel-body">
              ${b.board_cont}
            </div>
            </div>
            </div>
            </c:forEach>
            </c:if>
            
            
            
          </div>
        </div>
      </div>
       
<jsp:include page="../../include/footer.jsp" />