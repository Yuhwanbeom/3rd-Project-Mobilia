<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" type="text/css" href="./css/member/login.css">

<div class="login1">
	<form action="sendEmail" method="post" name="sendEmail">
	
		<div class="login2">
		<h2 >비밀번호 찾기</h2>
			<h3>아이디</h3>
			<input placeholder="아이디를 입력하세요"class="input1" type="text" id="m_id" name="m_id" required>
			<h3>Email</h3>
			<input placeholder="가입 Email을 입력하세요"class="input1" type="email" id="m_email" name="m_email" required>
			
			<p  class="login3">
				<button class="btn1" id="checkEmail">비밀번호 발송</button>
				<button class="btn1" onclick="location='member_login'">취소</button>
			</p>
		</div>
	</form>
</div>

<script>
    $("#checkEmail").on('click',function () {
        var m_email = $("#m_email").val();
        var m_id = $("#m_id").val();
        var sendEmail = document.forms["sendEmail"];
        $.ajax({
            type: 'post',
            url: '/sendEmail',
            data: {
                m_email : m_email,
                m_id: m_id
            },
            dataType: "text",
            success: function (result) {
                if(result == "SUCCESS"){
                    alert('임시비밀번호를 전송 했습니다.');
                    location.reload();
                }else if(result=="NOUSER"){
                    alert('가입되지 않은 정보입니다.');
                    location.reload();
                }
            },error: function () {
                console.log('에러 체크!!')
            }
        })
    });
</script>
<jsp:include page="../include/footer.jsp" />