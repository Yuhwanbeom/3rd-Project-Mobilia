/**
 * board_main.js
 */
 
  $('.panel-collapse').on('show.bs.collapse', function () {
    $(this).siblings('.panel-heading').addClass('active');
  });

  $('.panel-collapse').on('hide.bs.collapse', function () {
    $(this).siblings('.panel-heading').removeClass('active');
  });
  
  function qnaPwdCheck(){
   	
  	if($.trim($("#id").val()) == $.trim($("#board_name").val())){
  	 return location='community_view?board_no='+board_no+'&board_type=qna&page='+page+'&state=cont';
  	}else{
  	 var pwd = prompt('게시물 비밀번호를 입력하세요');
  	 var board_pwd = document.getElementById("board_pwd").value;
  	 if(board_pwd == pwd){
  	  return location='community_view?board_no='+board_no+'&board_type=qna&page='+page+'&state=cont';
  	 }else{
  	  return false;
  	 }
  	}
  }