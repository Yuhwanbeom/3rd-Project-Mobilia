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