/**
 * board_cont.js
 */
  function replySubmit(){
  	if($.trim($("#reply_cont").val()) == ""){
  	 alert("댓글내용을 입력해 주세요!");
	 $("#reply_cont").val("").focus();
	 return false;
  	}
  }
  
  function boardDel(board_no, page){
  	var result = confirm("게시물을 삭제하시겠습니까?");
    if(result){
    	location='community_view?board_no='+board_no+'&page='+page+'&state=del'
    }else{
    	return null;
    }
  }